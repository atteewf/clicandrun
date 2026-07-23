package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.klikego_lite.model.FinalResult;
import com.ateew.klikego_lite.service.FinalResultService;

@RestController
public class FinalResultController {

    @Autowired
    private FinalResultService finalResultService;

    @GetMapping("/finalresult")
    public Iterable<FinalResult> getFinalResult() {
        return finalResultService.getFinalResult();
    }
}