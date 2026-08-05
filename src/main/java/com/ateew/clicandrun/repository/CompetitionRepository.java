package com.ateew.clicandrun.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.Competition;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    Page<Competition> findByYear(Integer year, Pageable pageable);
}