package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}