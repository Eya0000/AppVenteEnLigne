package com.fst.AppVenteEnLigne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fst.AppVenteEnLigne.entities.Order;



public interface OrderRepository extends JpaRepository <Order,Long> {

}
