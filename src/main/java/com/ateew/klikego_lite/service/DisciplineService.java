package com.ateew.klikego_lite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ateew.klikego_lite.repository.DisciplineRepository;
import com.ateew.klikego_lite.exception.DisciplineNotFoundException;
import com.ateew.klikego_lite.model.Discipline;

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

    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }
}