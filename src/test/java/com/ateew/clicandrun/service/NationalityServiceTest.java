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
import com.ateew.clicandrun.dto.NationalityDto;
import com.ateew.clicandrun.exception.NationalityNotFoundException;
import com.ateew.clicandrun.model.Nationality;
import com.ateew.clicandrun.repository.NationalityRepository;

@ExtendWith(MockitoExtension.class)
public class NationalityServiceTest {

    @Mock
    private NationalityRepository nationalityRepository;
    @InjectMocks
    private NationalityService nationalityService;

    @Test
    void devrait_creer_une_nationalite_sans_id() {
        NationalityDto dto = new NationalityDto();
        dto.setCountryName("France");
        dto.setCountryAbbr("FRA");

        Nationality nationality = new Nationality();
        nationality.setCountryName("France");

        when(nationalityRepository.save(any(Nationality.class))).thenReturn(nationality);

        Nationality resultat = nationalityService.saveNationality(dto, null);
        assertEquals("France", resultat.getCountryName());
    }

    @Test
    void nationality_faux_id() {
        long id = 100;
        when(nationalityRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NationalityNotFoundException.class, () -> {
            nationalityService.getOneNationality(id);
        });
    }
}