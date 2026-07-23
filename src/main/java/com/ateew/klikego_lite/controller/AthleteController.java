
package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.klikego_lite.model.Athlete;
import com.ateew.klikego_lite.service.AthleteService;

@RestController
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("/athlete")
    public Iterable<Athlete> getAthlete() {
        return athleteService.getAthlete();
    }

} 