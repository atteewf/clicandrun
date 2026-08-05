
package com.ateew.clicandrun.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompetitionDto {
    @NotBlank(message = " Le nom de la competition est obligatoire")
    private String name;

    @NotNull(message = " La date de départ est obligatoire")
    private LocalDate  startDate;
    
    @NotNull(message = " La date de fin est obligatoire")
    private LocalDate  endDate;
   

    @NotBlank(message = " Le lieu de la competition est obligatoire")
    private String location;

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
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

}
