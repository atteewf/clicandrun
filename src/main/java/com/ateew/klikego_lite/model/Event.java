package com.ateew.klikego_lite.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;


@Entity
@Table(name ="event")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private double wind;
    private LocalDate final_date;
    

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;
    
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    
     public long getId(){
        return id;
    }
    
    public double getWind(){
        return wind;
    }
    public void setWind(double wind){
        this.wind = wind;
    }
 
    public LocalDate getFinalDate(){
        return final_date;
    }
    public void setFinalDate(LocalDate final_date){
        this.final_date = final_date;
    }

    
    public Competition getCompetitionId(){
        return competition;
    }
   
    public void setCompetitionId( Competition competition){
    this.competition = competition;
    }
 public Discipline getDisciplineId(){
        return discipline;
    }
   
    public void setDisciplineId( Discipline discipline){
    this.discipline = discipline;
    }

}
