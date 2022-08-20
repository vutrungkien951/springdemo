/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.repository.impl;

import com.vtk.pojo.User;
import com.vtk.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class UserRepositoryImpl implements UserRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void addUser(User user) {
        this.sessionFactory.getObject().getCurrentSession().save(user);
    }

    @Override
    public List<User> getUsers(String username) {
        List<User> users;
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = builder.createQuery(User.class);

        Root<User> root = cr.from(User.class);

        CriteriaQuery<User> query = cr.select(root);
        if (!username.isEmpty())
            query.where(builder.equal(root.get("username"), username));

        users = session.createQuery(query).getResultList();
        
        return users;
    }
    
}
