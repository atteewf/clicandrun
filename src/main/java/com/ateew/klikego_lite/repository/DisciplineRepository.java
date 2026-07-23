package com.ateew.klikego_lite.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ateew.klikego_lite.model.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}