/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.repository.impl;

import com.vtk.pojo.Category;
import com.vtk.repository.CategoryRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kien
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Category> getCategories() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.getNamedQuery("Category.findAll");
        
        return q.getResultList();
    }

    @Override
    public Category getCategoryById(int cateId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.getNamedQuery("Category.findById").setParameter("id", cateId);
        
        Object c = q.getSingleResult();
        return (Category) c;
    }
    
}
