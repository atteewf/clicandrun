package com.ateew.clicandrun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.dto.CompetitionDto;
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

    public Competition saveCompetition(CompetitionDto competitionDto,Long id) {
         Competition competition = new Competition();
          if (id != null) {
            competition.setId(id);
        }
        competition.setName(competitionDto.getName());
        competition.setStartDate(competitionDto.getStartDate());
        competition.setEndDate(competitionDto.getEndDate());
        competition.setLocation(competitionDto.getLocation());
        competition.setYear(competitionDto.getEndDate().getYear());
        return competitionRepository.save(competition);
    }
}