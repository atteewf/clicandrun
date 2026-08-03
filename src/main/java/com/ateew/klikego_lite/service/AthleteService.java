package com.ateew.klikego_lite.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ateew.klikego_lite.repository.AthleteRepository;
import com.ateew.klikego_lite.dto.AthleteDto;
import com.ateew.klikego_lite.exception.AthleteNotFoundException;
import com.ateew.klikego_lite.model.Athlete;


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