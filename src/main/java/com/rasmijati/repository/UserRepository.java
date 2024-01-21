/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmi
 */
public class UserRepository {
    private List<User> list;

    public UserRepository() {
        list = new ArrayList();
    }
    
    public void Create(User user){
        this.list.add(user);
    }
    
    public List<User> Show(){
        return list;
    }
    
    public User ShowById(Long id){
        for( User user : list){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
    
    public void Delete(User user){
        this.list.remove(user);
    }
    
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
