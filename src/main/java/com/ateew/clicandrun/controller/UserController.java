package com.ateew.clicandrun.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.dto.UserMeDto;
import com.ateew.clicandrun.model.User;
import com.ateew.clicandrun.repository.UserRepository;


@RestController
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/me")
    public UserMeDto getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        User user =  userRepository.findByEmail(email);
        UserMeDto dto = new UserMeDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        if (user.getAthlete() != null) {
    dto.setAthleteId(user.getAthlete().getId());}
    
        return dto;
        // à toi de compléter :
        // 1. récupérer l'email depuis authentication
        // 2. chercher le User correspondant
        // 3. construire et retourner un UserMeDto
    }
}