/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.services;

import com.vtk.pojo.Category;
import java.util.List;

/**
 *
 * @author kien
 */
public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(int cateId);
}
