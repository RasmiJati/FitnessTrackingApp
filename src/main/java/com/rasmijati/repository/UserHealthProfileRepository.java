/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.UserHealthProfile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmi
 */
public class UserHealthProfileRepository {
    
    private List<UserHealthProfile> list;

    public UserHealthProfileRepository() {
        list = new ArrayList();
    }
    
    public void Create(UserHealthProfile user){
        this.list.add(user);
    }
    
    public List<UserHealthProfile> Show(){
        return list;
    }
    
    public UserHealthProfile ShowById(Long id){
        for(UserHealthProfile u : list){
            if(u.getId().equals(id))
                return u;
        }
        return null;
    }
    
    public void Delete(UserHealthProfile user){
        this.list.remove(user);
    }
    
    public void Edit(UserHealthProfile user){
        this.Show().stream().filter(n->n.getId().equals(user.getId())).forEach((UserHealthProfile x) -> {
            x.setUser(user.getUser());
            x.setWeight(user.getWeight());
            x.setHeight(user.getHeight());
            x.setBmi(user.getBmi());
            x.setBp(user.getBp());
            x.setHeartrate(user.getHeartrate());
        });
    }
}
