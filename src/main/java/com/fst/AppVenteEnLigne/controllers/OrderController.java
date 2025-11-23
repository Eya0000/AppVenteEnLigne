package com.fst.AppVenteEnLigne.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
    private OrderRepository orderRepository;
	
	 @GetMapping
	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    @PostMapping
	    public Order addUser(@Valid @RequestBody Order order) {
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
