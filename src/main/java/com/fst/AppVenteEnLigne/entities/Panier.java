package com.fst.AppVenteEnLigne.entities;




import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

@Entity
public class Panier {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@OneToOne
	@JoinColumn(name = "user_id") 
    private User user;
	
	

public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
public Panier (Long id,User user) {
this.id=id;
this.user=user;
}
public Panier() {}
}