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

import com.fst.AppVenteEnLigne.entities.OrderItem;
import com.fst.AppVenteEnLigne.repository.OrderItemRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {
	
	@Autowired
    private OrderItemRepository orderItemRepository;
	
	 @GetMapping
	    public List<OrderItem> getAllOrderItems() {
	        return orderItemRepository.findAll();
	    }

	    @PostMapping
	    public OrderItem addUser(@Valid @RequestBody OrderItem orderItem) {
	        return orderItemRepository.save(orderItem);
	    }


	    @PutMapping("/{id}")
	    public OrderItem updateOrderItem(@PathVariable Long id, @RequestBody OrderItem updated) {
	    	OrderItem ord = orderItemRepository.findById(id).get(); 
	        ord.setQuantity(updated.getQuantity());
	        ord.setOrder(updated.getOrder());
	        
	   
	        return orderItemRepository.save(ord);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOrderItem(@PathVariable Long id) {
	        orderItemRepository.deleteById(id);
	    }	


}
