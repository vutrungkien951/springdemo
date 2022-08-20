/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.services.impl;

import com.vtk.pojo.User;
import com.vtk.repository.UserRepository;
import com.vtk.services.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kien
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userRepository.addUser(user);
    }



    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        List<User> users = this.userRepository.getUsers(string);
        if(users.isEmpty()){
            throw new UsernameNotFoundException("Khong ton tai!");
        }
        User u = users.get(0);
        Set<GrantedAuthority> authorites = new HashSet<>();
        authorites.add(new SimpleGrantedAuthority(u.getUserRole()));
        
        return new org.springframework.security.core.userdetails.User(u.getUsername(),
                u.getPassword(), authorites);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUsers(username).get(0);
    }
    
}
