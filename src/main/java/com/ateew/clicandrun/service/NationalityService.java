package com.ateew.clicandrun.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.exception.NationalityNotFoundException;
import com.ateew.clicandrun.model.Nationality;
import com.ateew.clicandrun.repository.NationalityRepository;

@Service
public class NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    public Nationality getOneNationality(final long id) {
        return nationalityRepository.findById(id).orElseThrow(()->new NationalityNotFoundException(id));
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