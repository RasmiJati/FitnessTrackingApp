/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.PhysicalActivity;
import com.rasmijati.model.User;
import com.rasmijati.repository.PhysicalActivityRepository;
import com.rasmijati.repository.UserRepository;
import com.rasmijati.util.DateUtil;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rasmi
 */
public class PhysicalActivityController {

    private static UserRepository userRepository;
    private static PhysicalActivityRepository physicalActivityRepository;
    private static DateUtil dateUtil;

    public void Options(PhysicalActivityRepository physicalActivityRepository, UserRepository userRepository) {
        this.physicalActivityRepository = physicalActivityRepository;
        this.userRepository = userRepository;
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println();
            System.out.println("*************Performing Operation for Physical Activity**************");
            System.out.println();
            System.out.println("Enter 1 for Create Operation : ");
            System.out.println("Enter 2 for Delete Operation : ");
            System.out.println("Enter 3 for Edit Operation : ");
            System.out.println("Enter 4 for Show Operation : ");
            System.out.println("Enter 5 for Exit : ");
            System.out.println();
            System.out.println();
            System.out.println("Enter your choice : ");
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
                    System.out.println("Invalid Option!!");
                    break;
            }
        } while (!choice.equals("0"));
    }

    public static void Create() {
        Long id = null;
        User user = null;
        String activitytype = null;
        String duration = null;
        String caloriesburned = null;
        Date datelogged = null;
        dateUtil = new DateUtil();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Performing create operation---------------");

        while (id == null) {
            System.out.println("Enter id : ");
            id = sc.nextLong();
        }
        while (user == null) {
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
                if (user == null) {
                    System.out.println("User with id " + uid + " not found!! Please select another user!!!");
                    System.out.println();
                }
            }
        }
        while (activitytype == null || activitytype.isEmpty()) {
            System.out.println("Enter Activity Type : ");
            activitytype = sc.next();
        }

        while (duration == null || duration.isEmpty()) {
            System.out.println("Enter duration : ");
            duration = sc.next();
        }

        while (caloriesburned == null || caloriesburned.isEmpty()) {
            System.out.println("Enter Calories burned : ");
            caloriesburned = sc.next();
        }
        while (datelogged == null) {
            System.out.println("Enter Logged Date (yyyy-MM-dd): ");
            String dateStr = sc.next();
            datelogged = dateUtil.parseStringToDateOnly(dateStr);
        }
        PhysicalActivity physicalActivity = new PhysicalActivity(id, user, activitytype, duration, caloriesburned, datelogged);
        physicalActivityRepository.Create(physicalActivity);
        System.out.println("Create operation successfull!!!!");
    }

    public static void Show() {
        System.out.println("****************Physical Activity Information**********************");
        physicalActivityRepository.Show().stream().forEach(x -> System.out.println(x));
        System.out.println();
    }

    public static void Delete() {
        Long id;
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------Performing Delete Operation----------------");
        System.out.println("Enter id");
        id = sc.nextLong();
        PhysicalActivity physicalActivity = physicalActivityRepository.ShowById(id);
        while (physicalActivity == null) {
            System.out.println("Id " + id + " is invalid!!!");
            System.out.println("Delete for id " + id + " is failed !!!");
            return;
        }
        physicalActivityRepository.Delete(physicalActivity);
        System.out.println("Delete Operation for id " + id + " is successfull!!!");
    }

    public static void Edit() {
        Long id;
        User user = null;
        String activitytype = null;
        String duration = null;
        String caloriesburned = null;
        Date datelogged = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Performing edit operation---------------");
        System.out.println("Enter id : ");
        id = sc.nextLong();
        PhysicalActivity physicalActivity = physicalActivityRepository.ShowById(id);
        while (physicalActivity == null) {
            System.out.println("Id " + id + " is invalid!!!");
            System.out.println("Edit for id " + id + " is failed !!!");
            return;
        }
        while (user == null) {
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
                if (user == null) {
                    System.out.println("User with id " + uid + " not found!! Please select another user!!!");
                    System.out.println();
                }
            }
        }
        while (activitytype == null || activitytype.isEmpty()) {
            System.out.println("Enter Activity Type : ");
            activitytype = sc.next();
        }

        while (duration == null || duration.isEmpty()) {
            System.out.println("Enter duration : ");
            duration = sc.next();
        }

        while (caloriesburned == null || caloriesburned.isEmpty()) {
            System.out.println("Enter Calories burned : ");
            caloriesburned = sc.next();
        }
        while (datelogged == null) {
            System.out.println("Enter Logged Date (yyyy-MM-dd): ");
            String dateStr = sc.next();
            datelogged = dateUtil.parseStringToDateOnly(dateStr);
        }

        PhysicalActivity physicalActivities = new PhysicalActivity(id, user, activitytype, duration, caloriesburned, datelogged);
        physicalActivityRepository.Edit(physicalActivities);
        System.out.println("Edit Operation for id " + id + " is successfull!!");
    }

}
