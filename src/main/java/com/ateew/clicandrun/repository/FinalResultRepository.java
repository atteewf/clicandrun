package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.FinalResult;
import com.ateew.clicandrun.model.FinalResultId;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FinalResultRepository extends JpaRepository<FinalResult, FinalResultId> {
}
