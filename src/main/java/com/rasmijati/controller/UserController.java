/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.repository.UserRepository;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author rasmi
 */
public class UserController {

    private static UserRepository userRepository;

    public void Options(UserRepository userRepository) {
        this.userRepository = userRepository;
        Create();
        
    }

    public static void Create(){
        Long id;
        String name;
        String password;
        String email;
        Date dob;
        String gender;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter id:");
        String id1 = sc.next();
        id = Long.parseLong(id1);
        
        System.out.println("Enter name: ");
        name = sc.next();
        
        System.out.println("Enter email : ");
        email = sc.next();
        
        System.out.println("Enter password : ");
        password = sc.next();
        
        System.out.println("Enter Birth Date : ");
        String date = sc.next();
        dob = Date.valueOf(date);
        
        System.out.println("Enter gender :");
        gender = sc.next();
        
        User user = new User(id, name, email, password, dob, gender);
        userRepository.Create(user);
        System.out.println(userRepository.Show());
    }
}
