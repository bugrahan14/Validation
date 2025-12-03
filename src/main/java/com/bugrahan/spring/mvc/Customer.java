package com.bugrahan.spring.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName ;

    @NotNull(message = " İS REQUİRED BOŞ GEÇİLEMEZ")
    @Size(min = 1, message = "İS REQUİRED BOŞ GEÇİLEMEZ")
    private String lastName;

    @Min(value = 0,message = "MUST BE GREATER THAN OR EQUAL TO 0")
    @Max(value = 10,message = "MUST BE LESS THAN OR EQUAL TO 10")
    private int freePasses;



    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public Customer() {
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }
}
