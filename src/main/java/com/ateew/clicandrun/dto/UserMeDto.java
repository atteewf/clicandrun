package com.ateew.clicandrun.dto;

import com.ateew.clicandrun.model.Role;

public class UserMeDto {
    private Long id;
    private String email;
    private Role role;
    private Long athleteId;
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

      
    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

       public Long getAthleteId(){
        return athleteId;
    }
    public void setAthleteId(Long athleteId){
        this.athleteId = athleteId;
    } 
}