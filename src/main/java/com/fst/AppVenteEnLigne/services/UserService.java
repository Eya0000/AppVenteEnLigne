package com.fst.AppVenteEnLigne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fst.AppVenteEnLigne.entities.User;
import com.fst.AppVenteEnLigne.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public void registerUser(User user) {
        // Sauvegarde du user
        userRepository.save(user);

        // Notification au superadmin pour affecter un rôle
        String adminEmail = "superadmin@example.com";
        String subject = "Nouveau utilisateur inscrit";
        String body = "L'utilisateur " + user.getNameU() + " vient de s'inscrire. Merci d'affecter un rôle.";
        emailService.sendEmail(adminEmail, subject, body);
    }
}

