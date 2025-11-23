package com.fst.AppVenteEnLigne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fst.AppVenteEnLigne.entities.User;



public interface UserRepository extends JpaRepository <User,Long> { 

}
