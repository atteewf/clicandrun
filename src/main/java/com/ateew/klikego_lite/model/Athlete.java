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
    
    private String first_name;
    private String last_name;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    private LocalDate birth_date;
    
     public long getId(){
        return id;
    }
      public void setId(long id) {
    this.id = id;
}
    
    
    public String getFirst_name(){
        return first_name;
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

  
    public String getLast_name(){
        return last_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

      public LocalDate getBirthDate(){
        return birth_date;
    }
    public void setBirthDate(LocalDate birth_date){
        this.birth_date = birth_date;
    }
    
    public Nationality getNationalityId(){
        return nationality;
    }
   
    public void setNationalityId( Nationality nationality){
    this.nationality = nationality;
    }

 @Override
    public String toString() {
        return first_name + " " + last_name;
    }

}
