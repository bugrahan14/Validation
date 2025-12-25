package com.bugrahan.spring.mvc;

import com.bugrahan.spring.mvc.validation.BugraCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName ;

    @NotNull(message = " İS REQUİRED BOŞ GEÇİLEMEZ")
    @Size(min = 1, message = "İS REQUİRED BOŞ GEÇİLEMEZ")
    private String lastName;

    @Min(value = 0,message = "MUST BE GREATER THAN OR EQUAL TO 0")
    @Max(value = 10,message = "MUST BE LESS THAN OR EQUAL TO 10")
    @NotNull(message = " İS REQUİRED BOŞ GEÇİLEMEZ")
    private Integer freePasses;   // EĞER İNT KULLANILSAYDI DEFAULT DEĞER 0 OLACAĞINDAN HATA ALACKTIK

    @NotNull(message = " İS REQUİRED BOŞ GEÇİLEMEZ")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode ;

    @BugraCode
    private String bugraCode;

    public String getBugraCode() {
        return bugraCode;
    }

    public void setBugraCode(String bugraCode) {
        this.bugraCode = bugraCode;
    }

    public String getPostalCode(){
        return this.postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode=postalCode;
    }


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
