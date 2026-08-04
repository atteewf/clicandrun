package com.ateew.clicandrun.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name ="discipline")
public class Discipline {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    
    private String name;
    private boolean isMen;
    private int distance;

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


     public boolean isMen(){
        return isMen;
    }
    public void setIsMen(boolean isMen){
        this.isMen = isMen;
    }
public int getDistance(){
    return distance;
}
public void setDistance(int distance){
    this.distance = distance;
}

}
