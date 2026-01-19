package com.fst.AppVenteEnLigne.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fst.AppVenteEnLigne.entities.Order;



public interface OrderRepository extends JpaRepository <Order,Long> {
	List<Order> findByUserId(Long userId);
	
	// Méthode existante
<<<<<<< HEAD
		@Query("SELECT o FROM Order o LEFT JOIN FETCH o.orderItems WHERE o.id = :id")
		Optional<Order> findByIdWithItems(@Param("id") Long id);
		
		
		// <-- AJOUTER CETTE MÉTHODE pour fetch tous les orders avec leurs orderItems
	    @Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.orderItems")
	    List<Order> findAllWithItems();


	}
=======
	@Query("SELECT o FROM Order o LEFT JOIN FETCH o.orderItems WHERE o.id = :id")
	Optional<Order> findByIdWithItems(@Param("id") Long id);
	
	
	// <-- AJOUTER CETTE MÉTHODE pour fetch tous les orders avec leurs orderItems
    @Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.orderItems")
    List<Order> findAllWithItems();
>>>>>>> origin/main


