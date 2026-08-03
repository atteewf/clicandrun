package com.ateew.klikego_lite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ateew.klikego_lite.model.User;
import com.ateew.klikego_lite.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired 
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            
        User user = userRepository.findByEmail(email);
        if (user == null) {
           throw new UsernameNotFoundException("il manque l'email");
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
        .username(email)
        .password(user.getPassword())
        .roles(user.getRole().name())
        .build();
        
        return userDetails;
    }
}