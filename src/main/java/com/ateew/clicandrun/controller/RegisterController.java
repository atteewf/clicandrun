
package com.ateew.clicandrun.controller;

import com.ateew.clicandrun.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.dto.AthleteDto;
import com.ateew.clicandrun.dto.RegisterDto;
import com.ateew.clicandrun.model.Athlete;
import com.ateew.clicandrun.service.AthleteService;
import com.ateew.clicandrun.service.JWTService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.ateew.clicandrun.model.User;

import jakarta.validation.Valid;

@RestController
public class RegisterController {

    private final RegisterService registerService;
    @Autowired
    private RegisterService RegisterService;

    RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterDto dto) {
        return registerService.register(dto);
    }
} 