package com.ateew.clicandrun.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.ateew.clicandrun.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
     @Override
    @EntityGraph(attributePaths = "athlete")
    Page<User> findAll(Pageable pageable);
}