
package com.ateew.klikego_lite.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class AthleteDto {
    @NotBlank(message = " Le prenom est obligatoire")
    private String firstName;

    @NotBlank(message = " Le nom est obligatoire")
    private String  lastName;

     @NotNull(message = " La date de naissance est obligatoire")
     @Past(message = " La date de naissance dans le passé")
    private LocalDate  birthDate;
    

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
   public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }
}
