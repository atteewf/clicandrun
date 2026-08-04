package com.ateew.clicandrun.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.service.JWTService;

import org.springframework.security.core.Authentication;

    @RestController
    public class LoginController {
        private JWTService jwtService;
        public LoginController(JWTService jwtService) {
            this.jwtService = jwtService;
        }
    @PostMapping("/login")
    public String login(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

}


