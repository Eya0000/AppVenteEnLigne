package com.fst.AppVenteEnLigne.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fst.AppVenteEnLigne.entities.OrderItem;



public interface OrderItemRepository extends JpaRepository <OrderItem,Long> {

	Optional<OrderItem> findByOrderIdAndProductId(Long id, Long productId);
	@Query("""
			   SELECT COALESCE(SUM(oi.product.price * oi.quantity), 0)
			   FROM OrderItem oi
			   WHERE oi.order.id = :orderId
			""")
			Double calculateTotalByOrderId(@Param("orderId") Long orderId);


}
