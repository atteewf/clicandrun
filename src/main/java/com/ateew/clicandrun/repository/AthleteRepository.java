package com.ateew.clicandrun.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.Athlete;

import java.time.LocalDate;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    @Override
    @EntityGraph(attributePaths = "nationality")
    Page<Athlete> findAll(Pageable pageable);

    Athlete findByFirstNameAndLastNameAndBirthDate(String firstName, String lastName, LocalDate birthDate);
}