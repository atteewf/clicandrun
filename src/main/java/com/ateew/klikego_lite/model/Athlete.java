package com.ateew.klikego_lite.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;


@Entity
@Table(name ="athlete")
public class Athlete {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    private LocalDate birthDate;
    
     public long getId(){
        return id;
    }
      public void setId(long id) {
    this.id = id;
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
    
    public Nationality getNationality(){
        return nationality;
    }
   
    public void setNationality( Nationality nationality){
    this.nationality = nationality;
    }

 @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
