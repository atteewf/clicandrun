
package com.ateew.clicandrun.dto;



import jakarta.validation.constraints.NotBlank;

public class NationalityDto {
    @NotBlank(message = " Le nom du pays est obligatoire")
    private String countryName;

    @NotBlank(message = " Le code abbr est obligatoire")
    private String  countryAbbr;

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
