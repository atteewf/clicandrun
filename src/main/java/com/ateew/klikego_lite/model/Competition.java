package com.ateew.klikego_lite.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDate;


@Entity
@Table(name ="competition")
public class Competition {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    
    private String name;

    private LocalDate start_date;
    
    private LocalDate end_date;
    private int year;
    private String location;


     public long getId(){
        return id;
    }
      public void setId(long id) {
    this.id = id;
}
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public LocalDate getStartDate(){
        return start_date;
    }
    public void setStartDate(LocalDate start_date){
        this.start_date = start_date;
    }

    public LocalDate getEndDate(){
        return end_date;
    }
    public void setEndDate(LocalDate end_date){
        this.end_date = end_date;
    }

    public int getYear(){return year;}
    public void setYear(int year){
        this.year = year;
    }
public String getLocation(){
    return location;
}
public void setLocation(String location){
    this.location = location;
}


}
