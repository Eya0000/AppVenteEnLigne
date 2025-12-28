package com.fst.AppVenteEnLigne.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;

@Entity

@Table(name = "`order`")

public class Order {
	@JoinColumn(name = "user_id") 
	@ManyToOne
    private User user;
	
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true,  fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<OrderItem> orderItems  = new ArrayList<>();
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;  
	// @NotBlank(message="remplir le champ")
	     private LocalDate dateOr;
	     
	     @JsonProperty(access = JsonProperty.Access.READ_ONLY)
	     private Double totale = 0.0;

		 public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public LocalDate getDateOr() {
				return dateOr;
			}
			public void setDateOr(LocalDate dateOr) {
				this.dateOr = dateOr;
			}
			public Double getTotale() {
				return totale;
			}
			public void setTotale(Double totale) {
				this.totale = totale;
			}
			public User getUser() {
				return user;
			}
			public void setUser(User user) {
				this.user = user;
			}
			public List<OrderItem> getOrderItems() {
				return orderItems;
			}
			public void setOrderItems(List<OrderItem> orderItems) {
				this.orderItems = orderItems;
			}
			public Order(Long id,  LocalDate dateOr, Double totale, User user, List<OrderItem> orderItems) {
				this.id = id;
				this.dateOr = dateOr;
				this.totale = totale;
				this.user=user;
				this.orderItems = orderItems;
			}
			public Order() {}
			
			
			// 🔥 CALCUL AUTOMATIQUE DU TOTAL
			public void calculateTotal() {
			    double totale = 0.0;

			    if (orderItems != null) {
			        for (OrderItem item : orderItems) {

			            if (item.getProduct() != null &&
			                item.getProduct().getPrice() != null &&
			                item.getQuantity() != null) {

			                totale += item.getProduct().getPrice() * item.getQuantity();
			            }
			        }
			    }

			    this.totale = totale;
			}

}
