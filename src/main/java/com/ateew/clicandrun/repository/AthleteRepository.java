package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.Athlete;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}