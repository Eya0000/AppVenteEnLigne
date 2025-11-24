package com.fst.AppVenteEnLigne.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@NotBlank(message="le nom est obligatoire")
	private String nameCat;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id= id;
	}
	
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
	
	public Category(String nameCat ) {
			
		this.nameCat = nameCat;
		
	}
	public Category() {
		
	}
}
