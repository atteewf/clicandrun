package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.ateew.klikego_lite.dto.DisciplineDto;
import com.ateew.klikego_lite.model.Discipline;
import com.ateew.klikego_lite.service.DisciplineService;

import jakarta.validation.Valid;

@RestController
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/discipline")
    public Iterable<Discipline> getDiscipline() {
        return disciplineService.getDiscipline();
    }

       @GetMapping("/discipline/{id}")
    public Discipline getOneDiscipline(@PathVariable Long id) {
        return disciplineService.getOneDiscipline(id);
    }


         @PostMapping("/discipline")
    public Discipline createDiscipline(@Valid @RequestBody DisciplineDto disciplineDto) {
        return disciplineService.saveDiscipline(disciplineDto,null);
    }
    @PutMapping("/discipline/{id}")
    public Discipline updateDiscipline(@PathVariable Long id, @Valid @RequestBody DisciplineDto disciplineDto) {
        return disciplineService.saveDiscipline(disciplineDto, id);
    }

    @DeleteMapping("/discipline/{id}")
    public void deleteDiscipline(@PathVariable Long id) {
        disciplineService.deleteDiscipline(id);
    }
}