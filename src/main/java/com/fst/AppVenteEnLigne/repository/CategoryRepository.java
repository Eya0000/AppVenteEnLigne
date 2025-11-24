package com.fst.AppVenteEnLigne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fst.AppVenteEnLigne.entities.Category;



public interface CategoryRepository extends JpaRepository <Category,Long> {

}
