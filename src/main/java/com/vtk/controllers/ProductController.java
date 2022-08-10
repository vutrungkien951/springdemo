/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vtk.pojo.Product;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kien
 */
@Controller
@RequestMapping("/admin")
public class ProductController {
    
    @Autowired
    private Cloudinary cloudinary;
    
    @GetMapping("/products")
    public String products(){
        
        return "products";
    }
    
    @GetMapping("/addproduct")
    public String addProduct(@ModelAttribute (value="product") Product product){
        product = new Product();
        
        return "products";
    }
    
    @PostMapping("/addproduct")
    public String addProductProcess(@ModelAttribute (value="product") Product product,
            HttpServletRequest request) throws IOException{
//        MultipartFile img = product.getImg();
//        String rootDir = request.getSession().getServletContext().getRealPath("/");
//        
//        if(img != null && !img.isEmpty()){
//            img.transferTo(new File(rootDir + "/resources/images/"
//                + product.getName() + ".png"));
//            return "redirect:/";
//        }
        try{
            cloudinary.uploader().upload(product.getImg().getBytes(), 
                 ObjectUtils.asMap("resource_type", "auto"));
            
            return "redirect:/";
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        
            
        
        return "addproduct";
    }
}
