package com.ateew.klikego_lite.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ateew.klikego_lite.model.Nationality;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality, Long> {
}