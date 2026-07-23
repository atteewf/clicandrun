package com.ateew.klikego_lite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ateew.klikego_lite.repository.AthleteRepository;
import com.ateew.klikego_lite.model.Athlete;


@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public Optional<Athlete> getOneAthlete(final long id) {
        return athleteRepository.findById(id);
    }

    public Iterable<Athlete> getAthlete() {
        return athleteRepository.findAll();
    }

    public void deleteAthlete(final Long id) {
        athleteRepository.deleteById(id);
    }

    public Athlete saveAthlete(Athlete athlete) {
        Athlete saveAthlete = athleteRepository.save(athlete);
        return saveAthlete;
    }

}