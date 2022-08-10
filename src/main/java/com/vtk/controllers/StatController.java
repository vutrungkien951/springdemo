/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.controllers;

import com.vtk.services.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kien
 */
@Controller
@RequestMapping("/admin")
public class StatController {

    @Autowired
    private ProductService productService;

    @GetMapping("/stats")
    public String stats(Model model,
            @RequestParam(value = "quarter", required = false) int quarter,
            @RequestParam(value = "year", defaultValue = "2022") int year) {
        model.addAttribute("cateStats", this.productService.countProdByCate());
        model.addAttribute("renueve", this.productService.renueve(quarter, year));

        return "stats";
    }

}
