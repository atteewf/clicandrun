
package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.ateew.klikego_lite.model.Athlete;
import com.ateew.klikego_lite.service.AthleteService;

@RestController
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @GetMapping("/athlete")
    public Iterable<Athlete> getAthlete() {
        return athleteService.getAthlete();
    }
    @PostMapping("/athlete")
    public Athlete createAthlete(@RequestBody Athlete athlete) {
        return athleteService.saveAthlete(athlete);
    }
    @PutMapping("/athlete/{id}")
    public Athlete updateAthlete(@PathVariable Long id, @RequestBody Athlete athlete) {
        athlete.setId(id);
        return athleteService.saveAthlete(athlete);
    }

    @DeleteMapping("/athlete/{id}")
    public void deleteAthlete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
    }

} 