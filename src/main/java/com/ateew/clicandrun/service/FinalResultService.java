package com.ateew.clicandrun.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.exception.FinalResultNotFoundException;
import com.ateew.clicandrun.model.FinalResult;
import com.ateew.clicandrun.model.FinalResultId;
import com.ateew.clicandrun.repository.FinalResultRepository;

@Service
public class FinalResultService {

    @Autowired
    private FinalResultRepository finalResultRepository;

   public FinalResult getOneFinalResult(FinalResultId id) {
        return finalResultRepository.findById(id).orElseThrow(() -> new FinalResultNotFoundException(id));
    }

    public Iterable<FinalResult> getFinalResult() {
        return finalResultRepository.findAll();
    }

    public void deleteFinalResult(final FinalResultId id) {
        finalResultRepository.deleteById(id);
    }

    public FinalResult saveFinalResult(FinalResult finalResult) {
        return finalResultRepository.save(finalResult);
    }
}