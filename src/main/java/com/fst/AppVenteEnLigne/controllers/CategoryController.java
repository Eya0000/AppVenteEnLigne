package com.fst.AppVenteEnLigne.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fst.AppVenteEnLigne.entities.Category;
import com.fst.AppVenteEnLigne.repository.CategoryRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("categories")
public class CategoryController {
	
 @Autowired
 private CategoryRepository categoryRepository;

 @GetMapping
   public List<Category> getAllCategories() {
	   return categoryRepository.findAll();
	   }

 @PostMapping
	public Category createCategory(@RequestBody Category c) {
	     return categoryRepository.save(c);
	    }

	    @PutMapping("/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category updated) {
	        Category cat = categoryRepository.findById(id).get();
	        
	        cat.setNameCat(updated.getNameCat());
	        return categoryRepository.save(cat);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCategory(@PathVariable Long id) {
	        categoryRepository.deleteById(id);
	    }
	}



