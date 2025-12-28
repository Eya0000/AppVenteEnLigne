package com.fst.AppVenteEnLigne.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotBlank(message="le nom est obligatoire")
	private String nameCat;
		
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
	
	
	public Category(Long id , String nameCat ) {
		this.id= id;
		this.nameCat = nameCat;
		
	}
	public Category() {
		
	}
}
