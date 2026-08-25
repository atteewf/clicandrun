package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;
import com.ateew.clicandrun.model.FinalResult;
import com.ateew.clicandrun.model.FinalResultId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Repository
public interface FinalResultRepository extends JpaRepository<FinalResult, FinalResultId> {
    
    @Override
    @EntityGraph(attributePaths = {"event", "event.competition", "event.discipline", "athlete", "athlete.nationality"})
    Page<FinalResult> findAll(Pageable pageable);

    Page<FinalResult> findByFinalResultId_Athlete(Long athleteId, Pageable pageable);

    @EntityGraph(attributePaths = {"event", "event.competition", "event.discipline", "athlete", "athlete.nationality"})
    @Query("SELECT fr FROM FinalResult fr WHERE " +
           "LOWER(fr.athlete.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(fr.athlete.lastName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(fr.event.competition.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(fr.event.discipline.name) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<FinalResult> search(@Param("search") String search, Pageable pageable);
}
