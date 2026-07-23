package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.klikego_lite.model.Discipline;
import com.ateew.klikego_lite.service.DisciplineService;

@RestController
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/discipline")
    public Iterable<Discipline> getDiscipline() {
        return disciplineService.getDiscipline();
    }
}