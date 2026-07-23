package com.ateew.klikego_lite.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ateew.klikego_lite.model.Athlete;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}