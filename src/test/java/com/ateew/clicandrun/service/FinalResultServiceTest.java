package com.ateew.clicandrun.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ateew.clicandrun.dto.FinalResultDto;
import com.ateew.clicandrun.exception.FinalResultNotFoundException;
import com.ateew.clicandrun.model.Athlete;
import com.ateew.clicandrun.model.Event;
import com.ateew.clicandrun.model.FinalResult;
import com.ateew.clicandrun.model.FinalResultId;
import com.ateew.clicandrun.repository.AthleteRepository;
import com.ateew.clicandrun.repository.EventRepository;
import com.ateew.clicandrun.repository.FinalResultRepository;

@ExtendWith(MockitoExtension.class)
public class FinalResultServiceTest {

    @Mock
    private FinalResultRepository finalResultRepository;
    @Mock
    private EventRepository eventRepository;
    @Mock
    private AthleteRepository athleteRepository;
    @InjectMocks
    private FinalResultService finalResultService;

    @Test
    void devrait_creer_un_resultat() {
        FinalResultDto dto = new FinalResultDto();
        dto.setEventId(1L);
        dto.setAthleteId(2L);
        dto.setPlace(3);

        Event event = new Event();
        Athlete athlete = new Athlete();
        FinalResult finalResult = new FinalResult();
        finalResult.setPlace(3);

        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        when(athleteRepository.findById(2L)).thenReturn(Optional.of(athlete));
        when(finalResultRepository.save(any(FinalResult.class))).thenReturn(finalResult);

        FinalResult resultat = finalResultService.saveFinalResult(dto);
        assertEquals(3, resultat.getPlace());
    }

    @Test
    void finalresult_faux_id() {
        FinalResultId id = new FinalResultId(1L, 2L);
        when(finalResultRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(FinalResultNotFoundException.class, () -> {
            finalResultService.getOneFinalResult(id);
        });
    }
}