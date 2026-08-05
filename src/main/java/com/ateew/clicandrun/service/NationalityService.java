package com.ateew.clicandrun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.dto.NationalityDto;
import com.ateew.clicandrun.exception.NationalityNotFoundException;
import com.ateew.clicandrun.model.Nationality;
import com.ateew.clicandrun.repository.NationalityRepository;

@Service
public class NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    public Nationality getOneNationality(final long id) {
        return nationalityRepository.findById(id).orElseThrow(()->new NationalityNotFoundException(id));
    }

    public Iterable<Nationality> getNationality() {
        return nationalityRepository.findAll();
    }

    public void deleteNationality(final Long id) {
        nationalityRepository.deleteById(id);
    }

    public Nationality saveNationality(NationalityDto nationalityDto, Long id) {
        Nationality nationality = new Nationality();
        if(id !=null){nationality.setId(id);}
        nationality.setCountryName(nationalityDto.getCountryName());
        nationality.setCountryAbbr(nationalityDto.getCountryAbbr());
        return nationalityRepository.save(nationality);
    }
}