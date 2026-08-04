package com.ateew.clicandrun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.exception.CompetitionNotFoundException;
import com.ateew.clicandrun.model.Competition;
import com.ateew.clicandrun.repository.CompetitionRepository;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

     public Competition getOneCompetition(final long id) {
        return competitionRepository.findById(id).orElseThrow(()-> new CompetitionNotFoundException(id));
    }

    public Iterable<Competition> getCompetition() {
        return competitionRepository.findAll();
    }

    public void deleteCompetition(final Long id) {
        competitionRepository.deleteById(id);
    }

    public Competition saveCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }
}