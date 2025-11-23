package com.fst.AppVenteEnLigne.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
	@JoinColumn(name = "role_id") 
	@ManyToOne
    private Role role;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;  
	 @NotBlank(message="remplir le champ")
	     private String nameU;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameU() {
		return nameU;
	}
	public void setNameU(String nameU) {
		this.nameU = nameU;
	}
	 public User() {}
		public User(Long id,  String nameU, Role role) {
			
			this.id = id;
			this.nameU = nameU;
			this.role=role;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}  
	 

}
