package com.ateew.clicandrun.dto;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

public class FinalResultDto {
    
    @NotNull(message = " Relier a un event")
    private Long eventId;
    
    @NotNull(message = " Relier a un athlete")
    private Long athleteId;

    private LocalTime  result;

    private Integer  place;
    
    private boolean isDsq;
    private boolean isDns;
    private boolean isDnf;

    public Long getEventId(){
        return eventId;
    }
    public void setEventId(Long eventId){
        this.eventId = eventId;
    }
    
   public Long getAthleteId(){
        return athleteId;
    }
    public void setAthleteId(Long athleteId){
        this.athleteId = athleteId;
    }
    
    public LocalTime getResult(){
        return result;
    }
    public void setResult(LocalTime result){
        this.result = result;
    }
 public Integer getPlace(){
        return place;
    }
    public void setPlace(Integer place){
        this.place = place;
    }

     
    public boolean isDsq(){
        return isDsq;

    }
    public void setIsDsq(boolean isDsq){
        this.isDsq = isDsq;
    }

     public boolean isDns(){
        return isDns;
    }
    public void setIsDns(boolean isDns){
        this.isDns = isDns;
    }


    public boolean isDnf(){
        return isDnf;
    }

    public void setIsDnf(boolean isDnf){
        this.isDnf = isDnf;
    }

}
