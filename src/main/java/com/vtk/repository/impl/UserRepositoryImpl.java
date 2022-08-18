/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.repository.impl;

import com.vtk.pojo.User;
import com.vtk.repository.UserRepository;
import java.util.List;
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
public class UserRepositoryImpl implements UserRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void addUser(User user) {
        this.sessionFactory.getObject().getCurrentSession().save(user);
    }

    @Override
    public List<User> getUsers(String username) {
        return null;
    }
    
}
