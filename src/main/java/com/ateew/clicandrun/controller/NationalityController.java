package com.ateew.clicandrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.model.Nationality;
import com.ateew.clicandrun.service.NationalityService;

import jakarta.validation.Valid;

import com.ateew.clicandrun.dto.NationalityDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class NationalityController {

    @Autowired
    private NationalityService nationalityService;

    @GetMapping("/nationality")
    public Iterable<Nationality> getNationality() {
        return nationalityService.getNationality();
    }
     @GetMapping("/nationality/{id}")
    public Nationality getOneNationality(@PathVariable Long id) {
        return nationalityService.getOneNationality(id);
    }
    
    @PostMapping("/nationality")
    public Nationality createNationality(@Valid @RequestBody NationalityDto nationalityDto){
        return nationalityService.saveNationality(nationalityDto,null);
    }
    @DeleteMapping("/nationality/{id}")
    public void deleteNationality(@PathVariable Long id){
        nationalityService.deleteNationality(id);
    }
    @PutMapping("/nationality/{id}")
    public Nationality updateNationality(@PathVariable Long id, @Valid @RequestBody NationalityDto nationalityDto) {
    return nationalityService.saveNationality(nationalityDto,id);
    }
}