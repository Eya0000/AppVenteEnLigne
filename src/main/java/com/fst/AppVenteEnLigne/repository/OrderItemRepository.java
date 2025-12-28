package com.fst.AppVenteEnLigne.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;


import com.fst.AppVenteEnLigne.entities.OrderItem;



public interface OrderItemRepository extends JpaRepository <OrderItem,Long> {
	Optional<OrderItem> findByOrderIdAndProductId(Long orderId, Long productId);

	

}
