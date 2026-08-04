package com.ateew.clicandrun.repository;

import org.springframework.stereotype.Repository;

import com.ateew.clicandrun.model.Nationality;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality, Long> {
}