package com.ateew.clicandrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.model.Competition;
import com.ateew.clicandrun.service.CompetitionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping("/competition")
    public Iterable<Competition> getCompetition() {
        return competitionService.getCompetition();
    }
      @GetMapping("/competition/{id}")
    public Competition getOneCompetition(@PathVariable Long id) {
        return competitionService.getOneCompetition(id);
    }
       @PostMapping("/competition")
    public Competition createCompetition(@RequestBody Competition competition) {
        return competitionService.saveCompetition(competition);
    }
    @PutMapping("/competition/{id}")
    public Competition updateCompetition(@PathVariable Long id, @RequestBody Competition competition) {
        competition.setId(id);
        return competitionService.saveCompetition(competition);
    }

    @DeleteMapping("/competition/{id}")
    public void deleteCompetition(@PathVariable Long id) {
        competitionService.deleteCompetition(id);
    }

}