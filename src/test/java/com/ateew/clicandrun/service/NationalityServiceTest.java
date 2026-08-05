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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

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
    @Test
void devrait_retourner_une_page_de_nationalites() {
    Pageable pageable = PageRequest.of(0, 2);
    Nationality n1 = new Nationality();
    Page<Nationality> pageAttendue = new PageImpl<>(List.of(n1), pageable, 1);

    when(nationalityRepository.findAll(pageable)).thenReturn(pageAttendue);

    Page<Nationality> resultat = nationalityService.getNationality(pageable);

    assertEquals(1, resultat.getTotalElements());
}
}