package com.ateew.clicandrun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.dto.AthleteDto;
import com.ateew.clicandrun.exception.AthleteNotFoundException;
import com.ateew.clicandrun.model.Athlete;
import com.ateew.clicandrun.model.FinalResult;
import com.ateew.clicandrun.repository.AthleteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public Athlete getOneAthlete(final long id) {
        return athleteRepository.findById(id).orElseThrow(()-> new AthleteNotFoundException(id));
    }

   public Page<Athlete> getAthlete(Pageable pageable) {
    return athleteRepository.findAll(pageable);
}

   public Page<Athlete> searchAthlete(String search, Pageable pageable) {
    if (search == null || search.isBlank()) {
        return athleteRepository.findAll(pageable);
    }
    return athleteRepository.search(search, pageable);
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