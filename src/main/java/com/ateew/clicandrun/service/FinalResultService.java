package com.ateew.clicandrun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.dto.FinalResultDto;
import com.ateew.clicandrun.exception.EventNotFoundException;
import com.ateew.clicandrun.exception.FinalResultNotFoundException;
import com.ateew.clicandrun.model.Athlete;
import com.ateew.clicandrun.model.Event;
import com.ateew.clicandrun.model.FinalResult;
import com.ateew.clicandrun.model.FinalResultId;
import com.ateew.clicandrun.exception.AthleteNotFoundException;
import com.ateew.clicandrun.repository.AthleteRepository;
import com.ateew.clicandrun.repository.EventRepository;
import com.ateew.clicandrun.repository.FinalResultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class FinalResultService {

    @Autowired
    private FinalResultRepository finalResultRepository;
    
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AthleteRepository athleteRepository;


   public FinalResult getOneFinalResult(FinalResultId id) {
        return finalResultRepository.findById(id).orElseThrow(() -> new FinalResultNotFoundException(id));
    }

    public Page<FinalResult> getFinalResult(Pageable pageable) {
        return finalResultRepository.findAll(pageable);
    }

      public Page<FinalResult> searchFinalResult(String search, Pageable pageable) {
    if (search == null || search.isBlank()) {
        return finalResultRepository.findAll(pageable);
    }
    return finalResultRepository.search(search, pageable);
    }

    public void deleteFinalResult(final FinalResultId id) {
        finalResultRepository.deleteById(id);
    }

    public FinalResult saveFinalResult(FinalResultDto finalResultDto) {
        FinalResult finalResult = new FinalResult();
        
        Event event = eventRepository.findById(finalResultDto.getEventId())
        .orElseThrow(() -> new EventNotFoundException(finalResultDto.getEventId()));
        
        Athlete athlete = athleteRepository.findById(finalResultDto.getAthleteId())
        .orElseThrow(() -> new AthleteNotFoundException(finalResultDto.getAthleteId()));

        finalResult.setEvent(event);
        finalResult.setAthlete(athlete);
        finalResult.setFinalResultId(new FinalResultId(event.getId(), athlete.getId()));
        finalResult.setResult(finalResultDto.getResult());
        finalResult.setPlace(finalResultDto.getPlace());
        finalResult.setIsDsq(finalResultDto.isDsq());
        finalResult.setIsDns(finalResultDto.isDns());
        finalResult.setIsDnf(finalResultDto.isDnf());
        
        return finalResultRepository.save(finalResult);
    }

    public Page<FinalResult> getByAthlete(Long athleteId, Pageable pageable) {
    return finalResultRepository.findByFinalResultId_Athlete(athleteId, pageable);
}
}