package com.ateew.clicandrun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ateew.clicandrun.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}