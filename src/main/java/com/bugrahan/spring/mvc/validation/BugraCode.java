package com.bugrahan.spring.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BugraCodeConstrainValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BugraCode {

    // DEFAULT BUGRA CODE
    public String value() default "BGR";

    // DEFAULT ERROR MESSAGE
    public String message() default "MUST START WİTH BGR";

    // DEFAULT GROUPS
    public Class<?>[] groups() default {};

    // DEFAULT PAYLOADS
    public Class<? extends Payload>[] payload() default {};




}
