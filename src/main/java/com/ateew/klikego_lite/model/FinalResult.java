package com.ateew.klikego_lite.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.EmbeddedId;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name ="final_result")
public class FinalResult {
    
    private LocalTime result;
    private int place;

    @EmbeddedId
    private FinalResultId finalresultid;
     
@ManyToOne
@JoinColumn(name = "event_id", insertable = false, updatable = false)
private Event event;

@ManyToOne
@JoinColumn(name = "athlete_id", insertable = false, updatable = false)
private Athlete athlete;

    private boolean is_dsq;
    private boolean is_dns;
    private boolean is_dnf;

    public FinalResultId getFinalResultId(){
        return finalresultid;
    }

    public void setFinalResultId(FinalResultId finalResultId){
        this.finalresultid = finalResultId;
    }


    public LocalTime getResult(){
        return result;
    }
    public void setResult(LocalTime result){
        this.result = result;
    }
 
    public int getPlace(){
        return place;
    }
    public void setPlace(int place){
        this.place = place;
    }

    
    public Event getEventId(){
        return event;
    }
   
    public void setEventId( Event event){
    this.event = event;
    }


 public Athlete getAthleteId(){
        return athlete;
    }
   
    public void setAthleteId( Athlete athlete){
    this.athlete = athlete;
    }
    
    public boolean getIsDsq(){
        return is_dsq;
    }
    public boolean getIsDns(){
        return is_dns;
    }
    public boolean getIsDnf(){
        return is_dnf;
    }
    public void setIsDsq(boolean is_dsq){
        this.is_dsq = is_dsq;
    }
    public void setIsDns(boolean is_dns){
        this.is_dns = is_dns;
    }
public void setIsDnf(boolean is_dnf){
        this.is_dnf = is_dnf;
    }


}
