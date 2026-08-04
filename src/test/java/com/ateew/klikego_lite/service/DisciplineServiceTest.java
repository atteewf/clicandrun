package com.ateew.klikego_lite.service;

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

import com.ateew.klikego_lite.dto.DisciplineDto;
import com.ateew.klikego_lite.exception.DisciplineNotFoundException;
import com.ateew.klikego_lite.model.Discipline;
import com.ateew.klikego_lite.repository.DisciplineRepository;
import com.ateew.klikego_lite.service.DisciplineService;

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
}