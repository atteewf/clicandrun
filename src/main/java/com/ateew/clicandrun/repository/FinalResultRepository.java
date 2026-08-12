package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.FinalResult;
import com.ateew.clicandrun.model.FinalResultId;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface FinalResultRepository extends JpaRepository<FinalResult, FinalResultId> {
    @Override
@EntityGraph(attributePaths = {"event", "event.competition", "event.discipline", "athlete", "athlete.nationality"})
Page<FinalResult> findAll(Pageable pageable);
}
