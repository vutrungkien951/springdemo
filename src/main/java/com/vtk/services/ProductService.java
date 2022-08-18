/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.services;

import com.vtk.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kien
 */
public interface ProductService {
    List<Product> getProducts(Map<String, String> params, int page);
    List<Product> getProducts();
    Product getProductById(int productId);
    List<Object> countProdByCate();
    List<Object> renueve(int quarter, int year);
    boolean addProduct(Product p);
    boolean deleteProduct(int productId);
    boolean checkProductName(String value);
}
