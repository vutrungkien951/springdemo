/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.repository;

import com.vtk.pojo.Category;
import java.util.List;

/**
 *
 * @author kien
 */
public interface CategoryRepository {
    List<Category> getCategories();

    /**
     *
     * @param id
     * @return
     */
    Category getCategoryById(int cateId);
}
