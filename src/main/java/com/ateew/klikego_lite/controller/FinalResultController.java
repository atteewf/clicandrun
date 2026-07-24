package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.ateew.klikego_lite.model.FinalResult;
import com.ateew.klikego_lite.service.FinalResultService;
import com.ateew.klikego_lite.model.FinalResultId;

@RestController
public class FinalResultController {

    @Autowired
    private FinalResultService finalResultService;

    @GetMapping("/finalresult")
    public Iterable<FinalResult> getFinalResult() {
        return finalResultService.getFinalResult();
    }
    
    @PostMapping("/finalresult")
    public FinalResult createFinalResult(@RequestBody FinalResult finalresult) {
        return finalResultService.saveFinalResult(finalresult);
    }
    
    @PutMapping("/finalresult/{eventId}/{athleteId}")
    public FinalResult updateFinalResult(@PathVariable Long eventId, @PathVariable Long athleteId, @RequestBody FinalResult finalresult) {
        FinalResultId id = new FinalResultId(eventId, athleteId);
        finalresult.setFinalResultId(id);
        return finalResultService.saveFinalResult(finalresult);
    }
    
    @DeleteMapping("/finalresult/{eventId}/{athleteId}")
    public void deleteFinalResult(@PathVariable Long eventId, @PathVariable Long athleteId) {
        FinalResultId id = new FinalResultId(eventId, athleteId);
        finalResultService.deleteFinalResult(id);
    }
}