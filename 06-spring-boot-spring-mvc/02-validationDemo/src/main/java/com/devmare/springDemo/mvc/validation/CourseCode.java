package com.devmare.springDemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstrainValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    //! Define default course code
    String value() default "DEVMARE";
    //! Define default error message
    String message() default "Must be start with DEVMARE";
    //! Define default groups
    Class<?>[] groups() default {};
    //! Define default payloads
    Class<? extends Payload>[] payload() default {};
}
