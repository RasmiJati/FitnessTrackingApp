/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.rasmijati.controller;

import com.rasmijati.repository.UserHealthProfileRepository;
import com.rasmijati.repository.UserRepository;
import java.util.Scanner;

/**
 *
 * @author rasmi
 */
public class MainController {

    public static void main(String[] args) {
        UserController userController = new UserController();
        UserRepository userRepository = new UserRepository();
        UserHealthProfileController userHealthProfileController = new UserHealthProfileController();
        UserHealthProfileRepository userHealthProfileRepository = new UserHealthProfileRepository();
        String choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println();
            System.out.println("############## Select an Operation #############");
            System.out.println();
            System.out.println("Enter 1 for User : ");
            System.out.println("Enter 2 for User Health Profile : ");
            System.out.println("Enter 3 for exit : ");
            System.out.println();
            System.out.println();
            System.out.println("Enter your choice : ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    userController.Options(userRepository);
                    break;
                case "2":
                    userHealthProfileController.Options(userHealthProfileRepository, userRepository);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid Option!!");
                    break;
            }
        } while (!choice.equals(0));
    }
}
