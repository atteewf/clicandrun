package com.ateew.clicandrun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.dto.DisciplineDto;
import com.ateew.clicandrun.exception.DisciplineNotFoundException;
import com.ateew.clicandrun.model.Discipline;
import com.ateew.clicandrun.repository.DisciplineRepository;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    public Discipline getOneDiscipline(final long id) {
        return disciplineRepository.findById(id).orElseThrow(()-> new DisciplineNotFoundException(id));
    }

    public Iterable<Discipline> getDiscipline() {
        return disciplineRepository.findAll();
    }

    public void deleteDiscipline(final Long id) {
        disciplineRepository.deleteById(id);
    }

    public Discipline saveDiscipline(DisciplineDto disciplineDto, Long id) {
        Discipline discipline = new Discipline();
        if(id != null){
            discipline.setId(id);
        }
        discipline.setDistance(disciplineDto.getDistance());
        discipline.setName(disciplineDto.getName());
        return disciplineRepository.save(discipline);
    }
}