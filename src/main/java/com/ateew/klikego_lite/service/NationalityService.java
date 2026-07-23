package com.ateew.klikego_lite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ateew.klikego_lite.repository.NationalityRepository;
import com.ateew.klikego_lite.model.Nationality;

@Service
public class NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    public Optional<Nationality> getOneNationality(final long id) {
        return nationalityRepository.findById(id);
    }

    public Iterable<Nationality> getNationality() {
        return nationalityRepository.findAll();
    }

    public void deleteNationality(final Long id) {
        nationalityRepository.deleteById(id);
    }

    public Nationality saveNationality(Nationality nationality) {
        return nationalityRepository.save(nationality);
    }
}