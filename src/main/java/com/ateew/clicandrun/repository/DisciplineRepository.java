package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}