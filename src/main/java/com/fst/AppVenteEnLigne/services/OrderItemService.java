package com.fst.AppVenteEnLigne.services;

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

    /**
     * Ajouter un produit à une commande et recalculer le total
     */
    public Order addOrderItem(OrderItem orderItem) {
        // 1️⃣ Charger la commande
        Order order = orderRepository.findById(orderItem.getOrder().getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // 2️⃣ Charger le produit
        Product product = productRepository.findById(orderItem.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 3️⃣ Vérifier si le produit existe déjà dans la commande
        Optional<OrderItem> existingItemOpt =
                orderItemRepository.findByOrderIdAndProductId(order.getId(), product.getId());

        if (existingItemOpt.isPresent()) {
            // Produit déjà présent → augmenter la quantité
            OrderItem existingItem = existingItemOpt.get();
            existingItem.setQuantity(existingItem.getQuantity() + orderItem.getQuantity());
            orderItemRepository.save(existingItem);
        } else {
            // Nouveau produit
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItemRepository.save(orderItem);

            // Ajouter à la collection pour que calculateTotal voie ce nouvel item
            order.getOrderItems().add(orderItem);
        }

        // 4️⃣ Recalculer le total depuis la base pour être sûr
        Double total = orderItemRepository.calculateTotalByOrderId(order.getId());
        if (total == null) total = 0.0;
        order.setTotale(total);

        // 5️⃣ Sauvegarde finale de la commande
        return orderRepository.save(order);
    }
}
