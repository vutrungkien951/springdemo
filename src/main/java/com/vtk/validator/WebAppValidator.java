/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.validator;

import com.vtk.pojo.Product;
import com.vtk.pojo.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author kien
 */
@Component
public class WebAppValidator implements Validator{
//    @Autowired
//    private javax.validation.Validator beanValidator;

    private Set<Validator> springValidators = new HashSet<>();
    
    @Override
    public boolean supports(Class<?> type) {
        return Product.class.isAssignableFrom(type) || 
                User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
    }
    
    public void setSpringValidators(Set<Validator> springValidators){
        this.springValidators = springValidators;
    }
    
}
