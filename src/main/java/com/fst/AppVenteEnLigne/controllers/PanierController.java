package com.fst.AppVenteEnLigne.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fst.AppVenteEnLigne.entities.Panier;
import com.fst.AppVenteEnLigne.repository.PanierRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Panier")
public class PanierController {
	@Autowired
	private PanierRepository panierRepository;
		
	@GetMapping
		 public List<Panier> getAllPaniers() {
		   return panierRepository.findAll();
		    }

	@PostMapping
	    public Panier addPanier(@Valid @RequestBody Panier p) {
		  return panierRepository.save(p);
			  }


	@PutMapping("/{id}")
	   public  Panier updatePanier(@PathVariable Long id, @RequestBody Panier updated) {
		 Panier pa = panierRepository.findById(id).get(); 
		 pa.setUser(updated.getUser());
			  return panierRepository.save(pa);
			    }

	@DeleteMapping("/{id}")
	   public void deletePanier(@PathVariable Long id) {
		 panierRepository.deleteById(id);
			    }	

			

	}



