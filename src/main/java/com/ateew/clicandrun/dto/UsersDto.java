package com.ateew.clicandrun.dto;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class UsersDto {
    @NotBlank(message = " Le nom du pays est obligatoire")
    private String countryName;

    @NotBlank(message = " Le code abbr est obligatoire")
    private String  countryAbbr;

    private LocalDate finalDate;
    private Float wind;
    public LocalDate getFinalDate(){
        return finalDate;
    }
    public void setFinalDate(LocalDate finalDate){
        this.finalDate = finalDate;
    }
    
   public Float getWind(){
        return wind;
    }
    public void setCountryAbbr(Float wind){
        this.wind = wind;
    }
    
}
