package com.fst.AppVenteEnLigne.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "`order`")

public class Order {
	@JoinColumn(name = "user_id") 
	@ManyToOne
    private User user;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;  
	 @NotBlank(message="remplir le champ")
	     private Date dateOr;
	     private double totale;
		 public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public Date getDateOr() {
				return dateOr;
			}
			public void setDateOr(Date dateOr) {
				this.dateOr = dateOr;
			}
			public double getTotale() {
				return totale;
			}
			public void setTotale(double totale) {
				this.totale = totale;
			}
			public User getUser() {
				return user;
			}
			public void setUser(User user) {
				this.user = user;
			}
			public Order(Long id,  Date dateOr, double totale, User user) {
				this.id = id;
				this.dateOr = dateOr;
				this.totale = totale;
				this.user=user;
			}
			public Order() {}

}
