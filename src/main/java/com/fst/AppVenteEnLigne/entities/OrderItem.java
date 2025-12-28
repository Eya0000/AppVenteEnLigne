package com.fst.AppVenteEnLigne.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
//import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
	    name = "order_item",
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = {"order_id", "product_id"})
	    }
	)
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;  
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false) 
	@JsonBackReference
    private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false) 
    private Product product;
	
	@JoinColumn(name = "panier_id") 
	@ManyToOne
    private Panier panier;
	
	
	 //@NotBlank(message="remplir le champ")
	 private Integer quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	 public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
	public OrderItem(Long id,  Integer quantity, Order order,Product product,Panier panier) {
		this.id = id;
		this.quantity = quantity;
		this.order=order;
		this.product=product;
		this.panier=panier;
	}
	public OrderItem() {}
	
	 // 🔥 Calcul du sous-total
        public double getSubTotal() {
        return quantity * product.getPrice();
    }

}
