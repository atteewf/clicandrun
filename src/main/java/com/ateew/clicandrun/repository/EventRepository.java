package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}