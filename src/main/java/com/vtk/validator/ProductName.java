/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author kien
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ProductNameValidator.class)
@Documented
public @interface ProductName {
    String message() default "";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
