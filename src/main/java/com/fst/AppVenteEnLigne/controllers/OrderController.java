package com.fst.AppVenteEnLigne.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fst.AppVenteEnLigne.entities.Order;
import com.fst.AppVenteEnLigne.repository.OrderRepository;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
    private OrderRepository orderRepository;
	
	// GET : toutes les commandes
	@GetMapping
	public List<Order> getAllOrders() {
	    return orderRepository.findAllWithItems();
	}


    // GET : une commande par ID avec les orderItems
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
	    Order order = orderRepository.findByIdWithItems(id)
	            .orElseThrow(() -> new RuntimeException("Order not found"));
	    return ResponseEntity.ok(order);
	}
	@GetMapping("/with-items")
	public List<Order> getAllOrdersWithItems() {
	    return orderRepository.findAllWithItems();
	}



	    @PostMapping
	    public Order addOrder(@Valid @RequestBody Order order) {
	        return orderRepository.save(order);
	    }


	    @PutMapping("/{id}")
	    public Order updateOrder(@PathVariable Long id, @RequestBody Order updated) {
	    	Order or = orderRepository.findById(id).get(); 
	        or.setDateOr(updated.getDateOr());
	        or.setTotale(updated.getTotale());
	        or.setUser(updated.getUser());
	   
	        return orderRepository.save(or);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOrder(@PathVariable Long id) {
	        orderRepository.deleteById(id);
	    }	

	

}
