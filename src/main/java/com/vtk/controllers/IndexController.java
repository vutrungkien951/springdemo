/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.controllers;

import com.vtk.pojo.Product;
import com.vtk.services.CategoryService;
import com.vtk.services.ProductService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kien
 */
@Controller
@ControllerAdvice
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    Logger log = Logger.getLogger(IndexController.class.getName());
    
    @ModelAttribute
    public void commonAttribute(Model model){
        model.addAttribute("categories", this.categoryService.getCategories());  
    }
    
    @RequestMapping("/")
    public String index(Model model, 
            @RequestParam Map<String, String> params){
        
        log.info("INTO "); 
        
        model.addAttribute("products", this.productService.getProducts(params, 0));
        
        
        return "index";
    }
    
    @RequestMapping("/test")
    public String test(Model model){
        return "index";
    }
    
    @GetMapping("/{productId}")
    public String productDetails(@PathVariable(value = "productId") int productId, Model model ){
        model.addAttribute("product", this.productService.getProductById(productId));
        
        return "productDetail";
    }
}
