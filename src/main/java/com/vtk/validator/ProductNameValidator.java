/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.validator;


import com.vtk.services.ProductService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author kien
 */
public class ProductNameValidator implements ConstraintValidator<ProductName, String>{

    @Autowired
    private ProductService productService;
    
    @Override
    public void initialize(ProductName constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        try{
//            return productService.checkProductName(value);
//        }catch (NoResultException ex){
//            return true;
//        }
        return false;
    }
    
}
