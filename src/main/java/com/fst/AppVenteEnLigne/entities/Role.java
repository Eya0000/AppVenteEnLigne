package com.fst.AppVenteEnLigne.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;

@Entity
public class Role {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)// ✅ clé primaire auto-incrémentée
	 private Long id;  
	 //@NotBlank(message="remplir le champ")
	     private String nameR;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameR() {
		return nameR;
	}
	
	public void setNameR(String nameR) {
		this.nameR = nameR;
	}
public Role(Long id,  String nameR) {
		
		this.id = id;
		this.nameR = nameR;
	}
public Role() {

}
	

}
