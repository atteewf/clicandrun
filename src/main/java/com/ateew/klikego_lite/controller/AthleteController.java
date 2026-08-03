
package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.ateew.klikego_lite.dto.AthleteDto;
import com.ateew.klikego_lite.model.Athlete;
import com.ateew.klikego_lite.service.AthleteService;

import jakarta.validation.Valid;

@RestController
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @GetMapping("/athlete")
    public Iterable<Athlete> getAthlete() {
        return athleteService.getAthlete();
    }

    @GetMapping("/athlete/{id}")
    public Athlete getOneAthlete(@PathVariable Long id) {
        return athleteService.getOneAthlete(id);
    }

    @PostMapping("/athlete")
    
    public Athlete createAthlete(@Valid @RequestBody AthleteDto athleteDto) {
        return athleteService.saveAthlete(athleteDto, null);
    }


    @PutMapping("/athlete/{id}")
    public Athlete updateAthlete(@PathVariable Long id,@Valid @RequestBody AthleteDto athleteDto) {
        return athleteService.saveAthlete(athleteDto, id);
    }

    @DeleteMapping("/athlete/{id}")
    public void deleteAthlete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
    }

} 