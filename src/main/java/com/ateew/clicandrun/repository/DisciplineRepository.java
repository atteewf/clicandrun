package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ateew.clicandrun.model.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
Page<Discipline> findByDistance(Integer distance, Pageable pageable);
}