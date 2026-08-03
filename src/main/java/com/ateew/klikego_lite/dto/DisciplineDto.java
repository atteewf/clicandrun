
package com.ateew.klikego_lite.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class DisciplineDto {

     @NotBlank(message = " Le nom est obligatoire")
    private String name;

    @Positive(message = " La Distance doit etre rempli correctement")
    private Integer distance;

    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getDistance(){
        return distance;
    }
    public void setDistance(Integer distance){
        this.distance = distance;
    }
}
