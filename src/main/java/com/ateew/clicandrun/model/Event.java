package com.ateew.clicandrun.model;


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
    private LocalDate finalDate;
    

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;
    
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    
     public long getId(){
        return id;
    }
      public void setId(long id) {
    this.id = id;
}
    
    
    public double getWind(){
        return wind;
    }
    public void setWind(double wind){
        this.wind = wind;
    }
 
    public LocalDate getFinalDate(){
        return finalDate;
    }
    public void setFinalDate(LocalDate finalDate){
        this.finalDate = finalDate;
    }

    
    public Competition getCompetition(){
        return competition;
    }
   
    public void setCompetition( Competition competition){
    this.competition = competition;
    }
 public Discipline getDiscipline(){
        return discipline;
    }
   
    public void setDiscipline( Discipline discipline){
    this.discipline = discipline;
    }

}
