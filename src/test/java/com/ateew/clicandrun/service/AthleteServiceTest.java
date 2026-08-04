package com.ateew.clicandrun.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ateew.clicandrun.dto.AthleteDto;
import com.ateew.clicandrun.model.Athlete;
import com.ateew.clicandrun.repository.AthleteRepository;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class AthleteServiceTest {

    @Mock
    private AthleteRepository athleteRepository;

    @InjectMocks
    private AthleteService athleteService;

    @Test
    void devrait_creer_une_Athlete_sans_id() {
        AthleteDto dto = new AthleteDto();
        dto.setFirstName("Usain");
        dto.setLastName("BOLT");
        dto.setBirthDate(LocalDate.of(1986, 8, 21));

        Athlete athlete = new Athlete();
        athlete.setFirstName("Usain");
        athlete.setLastName("BOLT");
        athlete.setBirthDate(LocalDate.of(1986, 8, 21));

        when(athleteRepository.save(any(Athlete.class))).thenReturn(athlete);

        Athlete resultat = athleteService.saveAthlete(dto, null);
        assertEquals("Usain", resultat.getFirstName());
assertEquals("BOLT", resultat.getLastName());
    }

    // @Test
    // void Athlete_faux_id() {
    //     long id = 100;
    //     when(AthleteRepository.findById(id)).thenReturn(Optional.empty());

    //     assertThrows(AthleteNotFoundException.class, () -> {
    //         AthleteService.getOneAthlete(id);
    //     });
    // }
}