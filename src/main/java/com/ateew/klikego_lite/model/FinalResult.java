package com.ateew.klikego_lite.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.EmbeddedId;
import java.time.LocalTime;


@Entity
@Table(name ="final_result")
public class FinalResult {
    
    private LocalTime result;
    private int place;

    @EmbeddedId
   private FinalResultId finalResultId;
     
@ManyToOne
@JoinColumn(name = "event_id", insertable = false, updatable = false)
private Event event;

@ManyToOne
@JoinColumn(name = "athlete_id", insertable = false, updatable = false)
private Athlete athlete;

    private boolean isDsq;
    private boolean isDns;
    private boolean isDnf;

    public FinalResultId getFinalResultId(){
        return finalResultId;
    }

    public void setFinalResultId(FinalResultId finalResultId){
        this.finalResultId = finalResultId;
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

    
    public Event getEvent(){
        return event;
    }
   
    public void setEvent( Event event){
    this.event = event;
    }


 public Athlete getAthlete(){
        return athlete;
    }
   
    public void setAthlete( Athlete athlete){
    this.athlete = athlete;
    }
    
    public boolean isDsq(){
        return isDsq;
    }
    public boolean isDns(){
        return isDns;
    }
    public boolean isDnf(){
        return isDnf;
    }
    public void setIsDsq(boolean isDsq){
        this.isDsq = isDsq;
    }
    public void setIsDns(boolean isDns){
        this.isDns = isDns;
    }
public void setIsDnf(boolean isDnf){
        this.isDnf = isDnf;
    }


}
