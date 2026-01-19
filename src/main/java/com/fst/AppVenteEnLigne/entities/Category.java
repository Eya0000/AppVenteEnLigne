package com.fst.AppVenteEnLigne.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name = "category")
=======
@Table(name="category")
>>>>>>> origin/main
public class Category {
	
	@Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//@NotBlank(message="le nom est obligatoire")
	private String nameCat;
	
	
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotBlank(message="le nom est obligatoire")
	private String nameCat;
		
>>>>>>> origin/main
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id= id;
	}
	
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
	
<<<<<<< HEAD
	public Category(Long id,String nameCat ) {
		this.id=id;	
=======
	public Category(Long id , String nameCat ) {
		this.id= id;
>>>>>>> origin/main
		this.nameCat = nameCat;
		
	}
	public Category() {
		
	}
}
