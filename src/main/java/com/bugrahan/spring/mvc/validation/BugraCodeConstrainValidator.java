package com.bugrahan.spring.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BugraCodeConstrainValidator implements ConstraintValidator<BugraCode , String> {

    private String coursePrefix;

    @Override
    public void initialize(BugraCode theBugraCode) {
        coursePrefix = theBugraCode.value();
    }

    @Override
    public boolean isValid(String theBugra, ConstraintValidatorContext theconstraintValidatorContext) {

        boolean result;

        if (theBugra !=null){
            result=theBugra.startsWith(coursePrefix);
        }

        else{
            return true;
        }


        return result;
    }
}
