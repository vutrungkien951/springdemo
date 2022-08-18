/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.repository;

import com.vtk.pojo.User;
import java.util.List;

/**
 *
 * @author kien
 */
public interface UserRepository {
    void addUser(User user);
    List<User> getUsers(String username);
}
