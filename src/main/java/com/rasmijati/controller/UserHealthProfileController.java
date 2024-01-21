/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.model.UserHealthProfile;
import com.rasmijati.repository.UserHealthProfileRepository;
import com.rasmijati.repository.UserRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rasmi
 */
public class UserHealthProfileController {

    private static UserHealthProfileRepository userHealthProfileRepository;
    private static UserRepository userRepository;

    public void Options(UserHealthProfileRepository userHealthProfileRepository, UserRepository userRepository) {
        this.userHealthProfileRepository = userHealthProfileRepository;
        this.userRepository = userRepository;
        Create();
    }

    public static void Create() {
        Long id = null;
        User user = null;
        Double weight = null;
        Double height = null;
        Double bmi = null;
        String bp = null;
        BigDecimal heartrate = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Performing create operation---------------");

        System.out.println("Enter id : ");
        id = sc.nextLong();

        System.out.println("Choose User : ");
        List<User> users = userRepository.Show();
        while (user == null) {
            System.out.println("------Users Information----------");
            System.out.println(users);

            Long uid = null;
            while (uid == null) {
                System.out.println("--------User Selection-----------");
                System.out.println("Enter id : ");
                uid = sc.nextLong();
            }
            user = userRepository.ShowById(uid);
        }
        System.out.println("Enter weight : ");
        weight = sc.nextDouble();

        System.out.println("Enter height : ");
        height = sc.nextDouble();

        System.out.println("Enter bmi : ");
        bmi = sc.nextDouble();

        System.out.println("Enter blood pressure : ");
        bp = sc.next();

        System.out.println("Enter heartrate : ");
        heartrate = sc.nextBigDecimal();

        UserHealthProfile userHealthProfile = new UserHealthProfile(id, user, weight, height, bmi, bp, heartrate);
        userHealthProfileRepository.Create(userHealthProfile);
        System.out.println("Create Operation Successfull!!");
        System.out.println(userHealthProfileRepository.Show());
    }
}
