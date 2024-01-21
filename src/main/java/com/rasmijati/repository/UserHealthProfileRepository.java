/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.UserHealthProfile;

/**
 *
 * @author rasmi
 */
public class UserHealthProfileRepository extends AbstractRepository<UserHealthProfile>{
    
    @Override
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
