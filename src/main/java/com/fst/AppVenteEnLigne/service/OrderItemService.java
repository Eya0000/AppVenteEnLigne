package com.fst.AppVenteEnLigne.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fst.AppVenteEnLigne.entities.Order;
import com.fst.AppVenteEnLigne.entities.OrderItem;
import com.fst.AppVenteEnLigne.entities.Product;
import com.fst.AppVenteEnLigne.repository.OrderItemRepository;
import com.fst.AppVenteEnLigne.repository.OrderRepository;
import com.fst.AppVenteEnLigne.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderItemService {
	
	private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemService(OrderItemRepository orderItemRepository,
                            OrderRepository orderRepository,
                            ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    
    public Order addOrderItem(OrderItem orderItem) {

    	// 1️⃣ Charger la commande
        Order order = orderRepository.findById(orderItem.getOrder().getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.getOrderItems().size(); // force le chargement de la collection

        // Initialiser la collection pour éviter lazy-loading
        if (order.getOrderItems() == null) {
            order.setOrderItems(new java.util.ArrayList<>());
        }

        // 2️⃣ Charger le produit
        Product product = productRepository.findById(orderItem.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 3️⃣ Vérifier si le produit existe déjà dans la commande
        Optional<OrderItem> existingItemOpt = orderItemRepository
                .findByOrderIdAndProductId(order.getId(), product.getId());

        if (existingItemOpt.isPresent()) {
            OrderItem existingItem = existingItemOpt.get();
            existingItem.setQuantity(existingItem.getQuantity() + orderItem.getQuantity());
            orderItemRepository.save(existingItem);
        } else {
            // Nouveau produit
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItemRepository.save(orderItem);
            order.getOrderItems().add(orderItem); // safe, collection initialisée
        }
       

        // 4️⃣ Calcul automatique du total
        order.calculateTotal();
        orderRepository.save(order);

        return order;
    }
    

}
