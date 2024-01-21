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
        String choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println();
            System.out.println("############## Performing operation for User Health Profile #############");
            System.out.println();
            System.out.println("Enter 1 for Create Operation :");
            System.out.println("Enter 2 for Delete Operation :");
            System.out.println("Enter 3 for Edit Operation :");
            System.out.println("Enter 4 for Show Operation :");
            System.out.println("Enter 5 for exit :");
            System.out.println();
            System.out.println();
            System.out.println("Enter your choice :");
            choice = sc.next();
            switch (choice) {
                case "1":
                    Create();
                    break;
                case "2":
                    Delete();
                    break;

                case "3":
                    Edit();
                    break;

                case "4":
                    Show();
                    break;

                case "5":
                    return;

                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }
        } while (!choice.equals(0));
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
    }

    public static void Show() {
        System.out.println("***************User Health Profile Information*************");
        userHealthProfileRepository.Show().stream().forEach(x -> System.out.println(x));
        System.out.println();
    }

    public static void Delete() {
        Long id = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Performing Delete Operation---------------------");
        System.out.println("Enter id : ");
        id = sc.nextLong();
        UserHealthProfile uhp = userHealthProfileRepository.ShowById(id);
        if (uhp == null) {
            System.out.println(id + " is invalid id !!");
            System.out.println("Delete operation for id " + id + " is failed !!!");
            return;
        }
        userHealthProfileRepository.Delete(uhp);
        System.out.println("Delete operation for id " + id + " is successfull!!");

    }

    public static void Edit() {
        Long id = null;
        User user = null;
        Double weight = null;
        Double height = null;
        Double bmi = null;
        String bp = null;
        BigDecimal heartrate = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Performing edit operation---------------");
        System.out.println("Enter id :");
        id = sc.nextLong();
        UserHealthProfile uhp = userHealthProfileRepository.ShowById(id);
        while (uhp == null) {
            System.out.println(id + " is invalid id !!");
            System.out.println("Edit operation for id " + id + " is failed !!!");
            return;
        }
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

        UserHealthProfile usersHealthProfile = new UserHealthProfile(id, user, weight, height, bmi, bp, heartrate);
        userHealthProfileRepository.Edit(usersHealthProfile);
        System.out.println("Edit operation for id " + id + " is successfull!!");
    }
}
