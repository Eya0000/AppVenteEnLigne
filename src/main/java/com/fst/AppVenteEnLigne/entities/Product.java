package com.fst.AppVenteEnLigne.entities;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotBlank(message="le nom est obligatoire")
	private String namePr;
	private Double price;
	private String description;
	private String image;
	private Integer quantityStock;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id= id;
	} 
	
	public String getNamePr() {
		return namePr;
	}
	public void setNamePr(String namePr) {
		this.namePr = namePr;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getQuantityStock() {
		return quantityStock;
	}
	public void setQuantityStock(Integer quantityStock) {
		this.quantityStock = quantityStock;
	}

	
	public Product(Long id, String namePr , Double price,String description, Category category,String image, Integer quantityStock ) {
		this.id= id;	
		this.namePr = namePr;
		this.price = price;
		this.description=description;
		this.category=category;
		this.image=image;
		this.quantityStock=quantityStock;
		
	}
	
	public Product() {
		
	}
	

}


