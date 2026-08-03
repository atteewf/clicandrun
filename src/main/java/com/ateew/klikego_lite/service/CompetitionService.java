package com.ateew.klikego_lite.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ateew.klikego_lite.repository.CompetitionRepository;
import com.ateew.klikego_lite.exception.CompetitionNotFoundException;
import com.ateew.klikego_lite.model.Competition;

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