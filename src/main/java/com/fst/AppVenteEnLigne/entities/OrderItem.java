package com.fst.AppVenteEnLigne.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class OrderItem {
	@JoinColumn(name = "order_id") 
	@ManyToOne
    private Order order;
	@JoinColumn(name = "product_id") 
	@OneToOne
    private Product product;
	@JoinColumn(name = "panier_id") 
	@ManyToOne
    private Panier panier;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;  
	 @NotBlank(message="remplir le champ")
	 private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	 public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
	public OrderItem(Long id,  int quantity, Order order,Product product,Panier panier) {
		this.id = id;
		this.quantity = quantity;
		this.order=order;
		this.product=product;
		this.panier=panier;
	}
	public OrderItem() {}

}
