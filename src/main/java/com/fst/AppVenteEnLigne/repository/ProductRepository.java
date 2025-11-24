package com.fst.AppVenteEnLigne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fst.AppVenteEnLigne.entities.Product;



public interface ProductRepository extends JpaRepository <Product,Long>{

}
