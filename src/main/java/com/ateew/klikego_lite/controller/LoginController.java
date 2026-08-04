package com.ateew.klikego_lite.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import com.ateew.klikego_lite.service.JWTService;

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


