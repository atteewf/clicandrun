package com.ateew.clicandrun.dto;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class EventDto {
    
    @NotNull(message = " Relier a une competition")
    private Long competitionId;
    
    @NotNull(message = " Relier a une discipline")
    private Long disciplineId;

    @NotNull
    private LocalDate finalDate;
    
    @NotNull
    private Float wind;

     public Long getCompetitionId(){
        return competitionId;
    }

    public void setCompetitionId(Long competitionId){
        this.competitionId = competitionId;
    }
    
     public Long getDisciplineId(){
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId){
        this.disciplineId = disciplineId;
    }
        public LocalDate getFinalDate(){
        return finalDate;
    }
    public void setFinalDate(LocalDate finalDate){
        this.finalDate = finalDate;
    }
    
   public Float getWind(){
        return wind;
    }
    public void setWind(Float wind){
        this.wind = wind;
    }
    
}
