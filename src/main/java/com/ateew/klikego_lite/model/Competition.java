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

    private LocalDate startDate;
    
    private LocalDate endDate;
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
        return startDate;
    }
    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }
    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
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
