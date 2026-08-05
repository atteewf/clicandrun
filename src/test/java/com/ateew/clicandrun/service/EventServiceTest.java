package com.ateew.clicandrun.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ateew.clicandrun.dto.EventDto;
import com.ateew.clicandrun.exception.EventNotFoundException;
import com.ateew.clicandrun.model.Competition;
import com.ateew.clicandrun.model.Discipline;
import com.ateew.clicandrun.model.Event;
import com.ateew.clicandrun.repository.CompetitionRepository;
import com.ateew.clicandrun.repository.DisciplineRepository;
import com.ateew.clicandrun.repository.EventRepository;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;
    @Mock
    private CompetitionRepository competitionRepository;
    @Mock
    private DisciplineRepository disciplineRepository;
    @InjectMocks
    private EventService eventService;

    @Test
    void devrait_creer_un_event_sans_id() {
        EventDto dto = new EventDto();
        dto.setCompetitionId(1L);
        dto.setDisciplineId(2L);
        dto.setFinalDate(LocalDate.of(2026, 9, 1));
        dto.setWind(1.2f);

        Competition competition = new Competition();
        Discipline discipline = new Discipline();
        Event event = new Event();
        event.setWind(1.2);

        when(competitionRepository.findById(1L)).thenReturn(Optional.of(competition));
        when(disciplineRepository.findById(2L)).thenReturn(Optional.of(discipline));
        when(eventRepository.save(any(Event.class))).thenReturn(event);

        Event resultat = eventService.saveEvent(dto, null);
        assertEquals(1.2, resultat.getWind());
    }

    @Test
    void event_faux_id() {
        long id = 100;
        when(eventRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(EventNotFoundException.class, () -> {
            eventService.getOneEvent(id);
        });
    }
}