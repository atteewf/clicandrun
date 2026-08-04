package com.ateew.clicandrun.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name ="nationality")
public class Nationality {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    
    private String countryName;
    private String countryAbbr;

     public long getId(){
        return id;
    }
    public void setId(long id) {
    this.id = id;
}
    
    public String getCountryName(){
        return countryName;
    }
    public void setCountryName(String countryName){
        this.countryName = countryName;
    }
     public String getCountryAbbr(){
        return countryAbbr;
    }
    public void setCountryAbbr(String countryAbbr){
        this.countryAbbr = countryAbbr;
    }


}
