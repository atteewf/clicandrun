package com.ateew.klikego_lite.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDate;


@Entity
@Table(name ="nationality")
public class Nationality {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    
    private String country_name;
    private String country_abbr;

     public long getId(){
        return id;
    }
    
    public String getCountryName(){
        return country_name;
    }
    public void setCountryName(String country_name){
        this.country_name = country_name;
    }
     public String getCountryAbbr(){
        return country_abbr;
    }
    public void setCountryAbbr(String country_abbr){
        this.country_abbr = country_abbr;
    }


}
