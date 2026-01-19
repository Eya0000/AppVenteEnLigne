package com.fst.AppVenteEnLigne.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
import com.fst.AppVenteEnLigne.entities.OrderItem;
import com.fst.AppVenteEnLigne.repository.OrderItemRepository;
import com.fst.AppVenteEnLigne.service.OrderItemService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/orderItems")
public class OrderItemController {
	
	private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
	
	@Autowired
    private OrderItemRepository orderItemRepository;
	
	 @GetMapping
	    public List<OrderItem> getAllOrderItems() {
	        return orderItemRepository.findAll();
	    }

	    @PostMapping
	    public Order addOrderItem(@RequestBody OrderItem orderItem) {
	        return orderItemService.addOrderItem(orderItem);
	    }


	    @PutMapping("/{id}")
	    public OrderItem updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
	        orderItem.setId(id);
	        return orderItemRepository.save(orderItem);
	    }


	    @DeleteMapping("/{id}")
	    public void deleteOrderItem(@PathVariable Long id) {
	        orderItemRepository.deleteById(id);
	    }	


}
