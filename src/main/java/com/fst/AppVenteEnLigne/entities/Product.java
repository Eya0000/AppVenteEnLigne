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
	private long id;
	
	//@NotBlank(message="le nom est obligatoire")
	private String namePr;
	private double price;
	private String description;
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id= id;
	} 
	
	public String getNamePr() {
		return namePr;
	}
	public void setNamePr(String namePr) {
		this.namePr = namePr;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private int quantity;
	
	public Product( String namePr , double price,String description, Category category,String image, int quantity) {
			
		this.namePr = namePr;
		this.price = price;
		this.description=description;
		this.category=category;
		this.image=image;
		this.quantity=quantity;
	}
	public Product() {
		
	}
	

}


