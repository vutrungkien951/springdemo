/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.validator;

import com.vtk.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author kien
 */
@Component
public class PassValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User u = (User) o;
        if(!u.getPassword().trim().equals(u.getConfirmPassword().trim())){
            errors.rejectValue("password", "user.password.error.notMatchMsg");
        }
    }
    
}
