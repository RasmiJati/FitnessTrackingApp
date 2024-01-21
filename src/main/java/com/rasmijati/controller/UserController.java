/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;
import com.rasmijati.model.User;


/**
 *
 * @author rasmi
 */
public class UserController{
    
    private User user;
    
    public void createUser(User user) {
        this.user = user;
    }
    public void showUser(){
        System.out.println(user.toString());
    }
    
}
