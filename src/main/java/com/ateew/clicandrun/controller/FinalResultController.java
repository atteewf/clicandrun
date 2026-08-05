package com.ateew.clicandrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.dto.FinalResultDto;
import com.ateew.clicandrun.model.FinalResult;
import com.ateew.clicandrun.model.FinalResultId;
import com.ateew.clicandrun.service.FinalResultService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
public class FinalResultController {

    @Autowired
    private FinalResultService finalResultService;

    @GetMapping("/finalresult")
    public Page<FinalResult> getFinalResult(Pageable pageable) {
        return finalResultService.getFinalResult(pageable);
    }
   @GetMapping("/finalresult/{eventId}/{athleteId}")
public FinalResult getOneFinalResult(@PathVariable Long eventId, @PathVariable Long athleteId) {
    FinalResultId id = new FinalResultId(eventId, athleteId);
    return finalResultService.getOneFinalResult(id);
}
    
     @PostMapping("/finalresult")
    public FinalResult createFinalResult(@Valid @RequestBody FinalResultDto finalResultDto) {
        return finalResultService.saveFinalResult(finalResultDto);
    }

    @PutMapping("/finalresult/{eventId}/{athleteId}")
    public FinalResult updateFinalResult(@PathVariable Long eventId, @PathVariable Long athleteId, @Valid @RequestBody FinalResultDto finalResultDto) {
        return finalResultService.saveFinalResult(finalResultDto);
    }
    
    @DeleteMapping("/finalresult/{eventId}/{athleteId}")
    public void deleteFinalResult(@PathVariable Long eventId, @PathVariable Long athleteId) {
        FinalResultId id = new FinalResultId(eventId, athleteId);
        finalResultService.deleteFinalResult(id);
    }
}