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

import com.fst.AppVenteEnLigne.entities.User;
import com.fst.AppVenteEnLigne.repository.UserRepository;


import jakarta.validation.Valid;


@CrossOrigin(origins="http://localhost:4200")
@RestController
 @RequestMapping("/users")
public class UserController {

	
	@Autowired
    private UserRepository userRepository;
	
	 @GetMapping
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @PostMapping
	    public User addUser(@Valid @RequestBody User user) {
	        return userRepository.save(user);
	    }


	    @PutMapping("/{id}")
	    public User updateUser(@PathVariable Long id, @RequestBody User updated) {
	    	User us = userRepository.findById(id).get(); 
	        us.setNameU(updated.getNameU());
	        us.setRole(updated.getRole());
	   
	        return userRepository.save(us);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) {
	        userRepository.deleteById(id);
	    }	

	
}
