package com.bugrahan.spring.mvc;

import jakarta.validation.constraints.*;

public class Customer {

    private String firstName ;

    @NotNull(message = " İS REQUİRED BOŞ GEÇİLEMEZ")
    @Size(min = 1, message = "İS REQUİRED BOŞ GEÇİLEMEZ")
    private String lastName;

    @Min(value = 0,message = "MUST BE GREATER THAN OR EQUAL TO 0")
    @Max(value = 10,message = "MUST BE LESS THAN OR EQUAL TO 10")
    @NotNull(message = " İS REQUİRED BOŞ GEÇİLEMEZ")
    private Integer freePasses;

    @NotNull(message = " İS REQUİRED BOŞ GEÇİLEMEZ")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode ;

    public String getPostalCode(){
        return this.postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode=postalCode;
    }

    // EĞER İNT KULLANILSAYDI DEFAULT DEĞER 0 OLACAĞINDAN HATA ALACKTIK
    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
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
