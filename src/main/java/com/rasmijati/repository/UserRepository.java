/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
/**
 *
 * @author rasmi
 */
public class UserRepository extends AbstractRepository<User>{
    @Override
    public void Edit(User user){
        this.Show().stream().filter(n -> n.getId().equals(user.getId())).forEach((User u) -> {
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setBirthdate(user.getBirthdate());
            u.setGender(user.getGender());
        });
    }
}
