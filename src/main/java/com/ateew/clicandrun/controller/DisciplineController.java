package com.ateew.clicandrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.dto.DisciplineDto;
import com.ateew.clicandrun.model.Discipline;
import com.ateew.clicandrun.service.DisciplineService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;

@RestController
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/discipline")
    public Page<Discipline> getDiscipline( @RequestParam(required = false) Integer distance, Pageable pageable) {
        return disciplineService.getDiscipline(distance, pageable);
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