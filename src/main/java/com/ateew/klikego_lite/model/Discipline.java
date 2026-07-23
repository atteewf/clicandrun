package com.ateew.klikego_lite.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDate;


@Entity
@Table(name ="discipline")
public class Discipline {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    
    private String name;
    private boolean is_men;
    private int distance;

     public long getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


     public boolean getIsMen(){
        return is_men;
    }
    public void setIsMen(boolean is_men){
        this.is_men = is_men;
    }
public int getDistance(){
    return distance;
}
public void setDistance(int distance){
    this.distance = distance;
}

}
