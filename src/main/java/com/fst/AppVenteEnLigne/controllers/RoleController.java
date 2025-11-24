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

import com.fst.AppVenteEnLigne.entities.Role;
import com.fst.AppVenteEnLigne.repository.RoleRepository;



@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


    @PostMapping
    public Role createRole(@RequestBody Role r) {
        return roleRepository.save(r);
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role updated) {
    	Role rol = roleRepository.findById(id).get();
        
        rol.setNameR(updated.getNameR());
        return roleRepository.save(rol);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }}


