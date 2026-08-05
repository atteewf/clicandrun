package com.ateew.clicandrun.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.ateew.clicandrun.dto.DisciplineDto;
import com.ateew.clicandrun.exception.DisciplineNotFoundException;
import com.ateew.clicandrun.model.Discipline;
import com.ateew.clicandrun.repository.DisciplineRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class DisciplineServiceTest {

    @Mock
    private DisciplineRepository disciplineRepository;

    @InjectMocks
    private DisciplineService disciplineService;

    @Test
    void devrait_creer_une_discipline_sans_id() {
        DisciplineDto dto = new DisciplineDto();
        dto.setName("Sprint 100m");
        dto.setDistance(100);

        Discipline discipline = new Discipline();
        discipline.setName("Sprint 100m");
        discipline.setDistance(100);

        when(disciplineRepository.save(any(Discipline.class))).thenReturn(discipline);

        Discipline resultat = disciplineService.saveDiscipline(dto, null);
        assertEquals("Sprint 100m", resultat.getName());
    }

    @Test
    void discipline_faux_id() {
        long id = 100;
        when(disciplineRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(DisciplineNotFoundException.class, () -> {
            disciplineService.getOneDiscipline(id);
        });
    }
    @Test
void devrait_retourner_une_page_de_disciplines_sans_filtre() {
    Pageable pageable = PageRequest.of(0, 2);
    Discipline d1 = new Discipline();
    Page<Discipline> pageAttendue = new PageImpl<>(List.of(d1), pageable, 1);

    when(disciplineRepository.findAll(pageable)).thenReturn(pageAttendue);

    Page<Discipline> resultat = disciplineService.getDiscipline(null, pageable);

    assertEquals(1, resultat.getTotalElements());
}

@Test
void devrait_retourner_une_page_de_disciplines_filtrees_par_distance() {
    Pageable pageable = PageRequest.of(0, 2);
    Discipline d1 = new Discipline();
    Page<Discipline> pageAttendue = new PageImpl<>(List.of(d1), pageable, 1);

    when(disciplineRepository.findByDistance(100, pageable)).thenReturn(pageAttendue);

    Page<Discipline> resultat = disciplineService.getDiscipline(100, pageable);

    assertEquals(1, resultat.getTotalElements());
}
}