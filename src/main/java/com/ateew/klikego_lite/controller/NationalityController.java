package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ateew.klikego_lite.model.Nationality;
import com.ateew.klikego_lite.service.NationalityService;


@RestController
public class NationalityController {

    @Autowired
    private NationalityService nationalityService;

    @GetMapping("/nationality")
    public Iterable<Nationality> getNationality() {
        return nationalityService.getNationality();
    }
    @PostMapping("/nationality")
    public Nationality createNationality(@RequestBody Nationality nationality){
        return nationalityService.saveNationality(nationality);
    }
    @DeleteMapping("/nationality/{id}")
    public void deleteNationality(@PathVariable Long id){
        nationalityService.deleteNationality(id);
    }
    @PutMapping("/nationality/{id}")
    public Nationality updateNationality(@PathVariable Long id, @RequestBody Nationality nationality) {
         nationality.setId(id);
    return nationalityService.saveNationality(nationality);
    }
}