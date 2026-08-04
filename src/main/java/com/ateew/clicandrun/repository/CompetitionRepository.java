
package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.Competition;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}