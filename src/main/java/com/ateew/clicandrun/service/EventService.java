package com.ateew.clicandrun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.dto.EventDto;
import com.ateew.clicandrun.exception.CompetitionNotFoundException;
import com.ateew.clicandrun.exception.EventNotFoundException;
import com.ateew.clicandrun.model.Competition;
import com.ateew.clicandrun.model.Discipline;
import com.ateew.clicandrun.model.Event;
import com.ateew.clicandrun.repository.EventRepository;
import com.ateew.clicandrun.repository.CompetitionRepository;
import com.ateew.clicandrun.repository.DisciplineRepository;
import com.ateew.clicandrun.exception.DisciplineNotFoundException;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    public Event getOneEvent(final long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    public Iterable<Event> getEvent() {
        return eventRepository.findAll();
    }

    public void deleteEvent(final Long id) {
        eventRepository.deleteById(id);
    }

    public Event saveEvent(EventDto eventDto, Long id) {
        Event event = new Event();

        Competition competition = competitionRepository.findById(eventDto.getCompetitionId())
        .orElseThrow(() -> new CompetitionNotFoundException(eventDto.getCompetitionId()));

        Discipline discipline = disciplineRepository.findById(eventDto.getDisciplineId())
        .orElseThrow(() -> new DisciplineNotFoundException(eventDto.getDisciplineId()));

          if (id != null) {event.setId(id);}
        
       event.setCompetition(competition);
        event.setDiscipline(discipline);
        
        event.setFinalDate(eventDto.getFinalDate());
        event.setWind(eventDto.getWind());

        return eventRepository.save(event);
    }
}