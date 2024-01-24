/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.repository.UserRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author rasmi
 */
public class UserController {

    private static UserRepository userRepository;

    public void Options(UserRepository userRepository) {
        this.userRepository = userRepository;
        String choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println();
            System.out.println("############## Performing operation for User #############");
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
        } while (!choice.equals("0"));
    }

    public static void Create() {
        Long id = null;
        String name = null;
        String password = null;
        String email = null;
        Date dob = null;
        String gender = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("---------Performing create operation---------");
        while (id == null) {
            System.out.println("Enter id:");
            String id1 = sc.next();
            id = Long.parseLong(id1);
        }
        while (name == null || name.isEmpty()) {
            System.out.println("Enter name: ");
            name = sc.next();
        }
        while (email == null || email.isEmpty()) {
            System.out.println("Enter email : ");
            email = sc.next();
        }
        while (password == null || password.isEmpty()) {
            System.out.println("Enter password : ");
            password = sc.next();
        }
        System.out.println("Enter Birth Date : ");
        String date = sc.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Parse the input string into a Date object
            dob = dateFormat.parse(date);

            // Print the parsed Date object
        } catch (ParseException e) {
            // Handle the case where the input string is not in the expected format
            System.out.println("Error parsing the date. Make sure it is in the format yyyy-MM-dd.");
        }
        while (gender == null || gender.isEmpty()) {
            System.out.println("Enter gender :");
            gender = sc.next();
        }
        User user = new User(id, name, email, password, dob, gender);
        userRepository.Create(user);
    }

    public static void Show() {
        System.out.println("**********User's Information***********");
        userRepository.Show().stream().forEach(x -> System.out.println(x));
        System.out.println();
    }

    public static void Delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------Performing delete operation---------");
        System.out.println("Enter id : ");
        Long id = sc.nextLong();
        User user = userRepository.ShowById(id);
        if (user == null) {
            System.out.println(id + " is invalid id !!");
            System.out.println("Delete operation for id " + id + " is failed !!!");
            return;
        }
        userRepository.Delete(user);
        System.out.println("Delete operation for id " + id + " is successfull!!");
    }

    public static void Edit() {
        Long id;
        String name = null;
        String email = null;
        String password = null;
        Date dob = null;
        String gender = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Performing Edit Operation--------------");
        System.out.println("Enter id : ");
        id = sc.nextLong();
        User user = userRepository.ShowById(id);
        if (user == null) {
            System.out.println(id + " is invalid id !!");
            System.out.println("Edit operation for id " + id + " is failed !!!");
            return;
        }
        while (name == null || name.isEmpty()) {
            System.out.println("Enter name: ");
            name = sc.next();
        }
        while (email == null || email.isEmpty()) {
            System.out.println("Enter email : ");
            email = sc.next();
        }
        while (password == null || password.isEmpty()) {
            System.out.println("Enter password : ");
            password = sc.next();
        }
        System.out.println("Enter Birth Date : ");
        String date = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dob = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Error parsing the date. Make sure it is in the format yyyy-MM-dd.");
        }

        while (gender == null || gender.isEmpty()) {
            System.out.println("Enter gender :");
            gender = sc.next();
        }

        User u = new User(id, name, password, email, dob, gender);
        userRepository.Edit(u);
        System.out.println("Edit operation for id " + id + " is successfull!!");
    }
}
