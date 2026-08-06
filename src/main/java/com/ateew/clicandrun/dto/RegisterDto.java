
package com.ateew.clicandrun.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class RegisterDto {
    @NotBlank(message = " Le prenom est obligatoire")
    private String firstName;

    @NotBlank(message = " Le nom est obligatoire")
    private String  lastName;

     @NotNull(message = " La date de naissance est obligatoire")
     @Past(message = " La date de naissance dans le passé")
    private LocalDate  birthDate;
   @NotBlank(message = "L'email est obligatoire")
@Email(message = "Email pas au bon format")
private String email;
    @NotBlank
    private String password;
    @NotNull(message = "La nationalité est obligatoire")
private Long nationalityId;

public Long getNationalityId(){
    return nationalityId;
}
public void setNationalityId(Long nationalityId){
    this.nationalityId = nationalityId;
}

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

    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
      
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
