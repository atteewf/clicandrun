package com.ateew.clicandrun.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<String> handleEventNotFound(EventNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
     @ExceptionHandler(AthleteNotFoundException.class)
    public ResponseEntity<String> handleAthleteNotFound(AthleteNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
     @ExceptionHandler(DisciplineNotFoundException.class)
    public ResponseEntity<String> handleDisciplineNotFound(DisciplineNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
     @ExceptionHandler(CompetitionNotFoundException.class)
    public ResponseEntity<String> handleCompetitionNotFound(CompetitionNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
     @ExceptionHandler(NationalityNotFoundException.class)
    public ResponseEntity<String> handleNationalityNotFound(NationalityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
       @ExceptionHandler(FinalResultNotFoundException.class)
    public ResponseEntity<String> handleFinalResultNotFound(FinalResultNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }


}