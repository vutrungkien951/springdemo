/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.services.impl;

import com.vtk.pojo.Product;
import com.vtk.repository.ProductRepository;
import com.vtk.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kien
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getProducts(Map<String, String> params, int page){
        return this.productRepository.getProducts(params, page);
    }

    @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.getProducts();
    }

    @Override
    public List<Object> countProdByCate() {
        return this.productRepository.countProdByCate();
    }

    @Override
    public List<Object> renueve(int quarter, int year) {
      return this.productRepository.renueve(quarter, year);
    }

    @Override
    public boolean addProduct(Product p) {
        return this.productRepository.addProduct(p);
    }
    
    
}
