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
import com.ateew.clicandrun.dto.CompetitionDto;
import com.ateew.clicandrun.exception.CompetitionNotFoundException;
import com.ateew.clicandrun.model.Competition;
import com.ateew.clicandrun.repository.CompetitionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class CompetitionServiceTest {

    @Mock
    private CompetitionRepository competitionRepository;
    @InjectMocks
    private CompetitionService competitionService;

    @Test
    void devrait_creer_une_competition_sans_id() {
        CompetitionDto dto = new CompetitionDto();
        dto.setName("Nocturne Saint-Aubin");
        dto.setStartDate(LocalDate.of(2026, 9, 1));
        dto.setEndDate(LocalDate.of(2026, 9, 1));
        dto.setLocation("Saint-Aubin-d'Aubigné");

        Competition competition = new Competition();
        competition.setName("Nocturne Saint-Aubin");

        when(competitionRepository.save(any(Competition.class))).thenReturn(competition);

        Competition resultat = competitionService.saveCompetition(dto, null);
        assertEquals("Nocturne Saint-Aubin", resultat.getName());
    }

    @Test
    void competition_faux_id() {
        long id = 100;
        when(competitionRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(CompetitionNotFoundException.class, () -> {
            competitionService.getOneCompetition(id);
        });
    }
    @Test
void devrait_retourner_une_page_de_competitions_sans_filtre() {
    Pageable pageable = PageRequest.of(0, 2);
    Competition c1 = new Competition();
    Page<Competition> pageAttendue = new PageImpl<>(List.of(c1), pageable, 1);

    when(competitionRepository.findAll(pageable)).thenReturn(pageAttendue);

    Page<Competition> resultat = competitionService.getCompetition(null, pageable);

    assertEquals(1, resultat.getTotalElements());
}

@Test
void devrait_retourner_une_page_de_competitions_filtrees_par_annee() {
    Pageable pageable = PageRequest.of(0, 2);
    Competition c1 = new Competition();
    Page<Competition> pageAttendue = new PageImpl<>(List.of(c1), pageable, 1);

    when(competitionRepository.findByYear(2026, pageable)).thenReturn(pageAttendue);

    Page<Competition> resultat = competitionService.getCompetition(2026, pageable);

    assertEquals(1, resultat.getTotalElements());
}
}