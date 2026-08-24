package com.ateew.clicandrun.controller;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.access.AccessDeniedException;
import com.ateew.clicandrun.repository.UserRepository;
import com.ateew.clicandrun.model.User;

@RestController
public class FinalResultController {

    private FinalResultService finalResultService;
    private UserRepository userRepository;

    public FinalResultController(FinalResultService finalResultService, UserRepository userRepository) {
        this.finalResultService = finalResultService;
        this.userRepository = userRepository;
    }

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
    public FinalResult createFinalResult(@Valid @RequestBody FinalResultDto finalResultDto, Authentication authentication) {
        checkOwnership(authentication, finalResultDto.getAthleteId());
        return finalResultService.saveFinalResult(finalResultDto);
    }

    @PutMapping("/finalresult/{eventId}/{athleteId}")
    public FinalResult updateFinalResult(@PathVariable Long eventId, @PathVariable Long athleteId, @Valid @RequestBody FinalResultDto finalResultDto, Authentication authentication) {
        checkOwnership(authentication, athleteId);
        return finalResultService.saveFinalResult(finalResultDto);
    }

    @DeleteMapping("/finalresult/{eventId}/{athleteId}")
    public void deleteFinalResult(@PathVariable Long eventId, @PathVariable Long athleteId, Authentication authentication) {
        checkOwnership(authentication, athleteId);
        FinalResultId id = new FinalResultId(eventId, athleteId);
        finalResultService.deleteFinalResult(id);
    }

    @GetMapping("/finalresult/athlete/{athleteId}")
    public Page<FinalResult> getResultsByAthlete(@PathVariable Long athleteId, Pageable pageable) {
        return finalResultService.getByAthlete(athleteId, pageable);
    }

    private void checkOwnership(Authentication authentication, Long athleteId) {
        boolean isAdmin = authentication.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin) {
            User currentUser = userRepository.findByEmail(authentication.getName());
            if (currentUser.getAthlete() == null || currentUser.getAthlete().getId() != athleteId) {
                throw new AccessDeniedException("Vous ne pouvez agir que sur votre propre profil athlète.");
            }
        }
    }
}