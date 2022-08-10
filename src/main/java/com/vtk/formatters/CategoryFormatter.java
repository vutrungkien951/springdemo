/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.formatters;

import com.vtk.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author kien
 */
public class CategoryFormatter implements Formatter<Category>{

    @Override
    public String print(Category obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Category parse(String string, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(string));
        
        return c;
    }
    
}
