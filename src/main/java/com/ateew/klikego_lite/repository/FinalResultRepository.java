package com.ateew.klikego_lite.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ateew.klikego_lite.model.FinalResult;
import com.ateew.klikego_lite.model.FinalResultId;

@Repository
public interface FinalResultRepository extends JpaRepository<FinalResult, FinalResultId> {
}
