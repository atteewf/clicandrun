package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.klikego_lite.model.Competition;
import com.ateew.klikego_lite.service.CompetitionService;

@RestController
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping("/competition")
    public Iterable<Competition> getCompetition() {
        return competitionService.getCompetition();
    }
}