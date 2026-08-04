package com.ateew.clicandrun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.dto.AthleteDto;
import com.ateew.clicandrun.exception.AthleteNotFoundException;
import com.ateew.clicandrun.model.Athlete;
import com.ateew.clicandrun.repository.AthleteRepository;


@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public Athlete getOneAthlete(final long id) {
        return athleteRepository.findById(id).orElseThrow(()-> new AthleteNotFoundException(id));
    }

    public Iterable<Athlete> getAthlete() {
        return athleteRepository.findAll();
    }

    public void deleteAthlete(final Long id) {
        athleteRepository.deleteById(id);
    }

    public Athlete saveAthlete(AthleteDto dto, Long id) {
       
         Athlete athlete = new Athlete();
          if (id != null) {
            athlete.setId(id);
        }
       athlete.setFirstName(dto.getFirstName());
         athlete.setLastName(dto.getLastName());
           athlete.setBirthDate(dto.getBirthDate());
       return athleteRepository.save(athlete);
    }

}