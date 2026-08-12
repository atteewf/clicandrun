package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.Event;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Override
@EntityGraph(attributePaths = {"competition", "discipline"})
Page<Event> findAll(Pageable pageable);
}