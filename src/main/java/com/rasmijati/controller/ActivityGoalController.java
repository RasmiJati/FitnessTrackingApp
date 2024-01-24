/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.ActivityGoal;
import com.rasmijati.model.User;
import com.rasmijati.repository.ActivityGoalRepository;
import com.rasmijati.repository.UserRepository;
import com.rasmijati.util.DateUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rasmi
 */
public class ActivityGoalController {

    private static UserRepository userRepository;
    private static ActivityGoalRepository activityGoalRepository;
    private static DateUtil dateUtil = new DateUtil();

    public void Options(ActivityGoalRepository activityGoalRepository, UserRepository userRepository) {
        this.activityGoalRepository = activityGoalRepository;
        this.userRepository = userRepository;
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println();
            System.out.println("*************Performing Operation for Activity Goal**************");
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
        String goalType = null;
        Double targetValue = null;
        Double currentValue = null;
        LocalDate date = null;
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
        while (goalType == null || goalType.isEmpty()) {
            System.out.println("Enter Goal Type : ");
            goalType = sc.next();
        }

        while (targetValue == null) {
            System.out.println("Enter target value : ");
            targetValue = sc.nextDouble();
        }
        while (currentValue == null) {
            System.out.println("Enter current value : ");
            currentValue = sc.nextDouble();
        }
        while (true) {
            System.out.println("Enter Date (yyyy-MM-dd): ");
            String dateStr = sc.next();
            date = dateUtil.parseStringToDate(dateStr);

            if (date != null) {
                break;
            } else {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
        ActivityGoal activityGoal = new ActivityGoal(id, user, goalType, targetValue, currentValue, date);
        activityGoalRepository.Create(activityGoal);
        System.out.println("Create operation successfull!!!!");
    }

    public static void Show() {
        System.out.println("****************Activity Goal Information**********************");
        activityGoalRepository.Show().stream().forEach(x -> System.out.println(x));
        System.out.println();
    }

    public static void Delete() {
        Long id;
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------Performing Delete Operation----------------");
        System.out.println("Enter id");
        id = sc.nextLong();
        ActivityGoal nutritionLog = activityGoalRepository.ShowById(id);
        while (nutritionLog == null) {
            System.out.println("Id " + id + " is invalid!!!");
            System.out.println("Delete for id " + id + " is failed !!!");
            return;
        }
        activityGoalRepository.Delete(nutritionLog);
        System.out.println("Delete Operation for id " + id + " is successfull!!!");
    }

    public static void Edit() {
        Long id = null;
        User user = null;
        String goalType = null;
        Double targetValue = null;
        Double currentValue = null;
        LocalDate date = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------Performing edit operation---------------");
        System.out.println("Enter id");
        id = sc.nextLong();
        ActivityGoal activitiesGoal = activityGoalRepository.ShowById(id);
        while (activitiesGoal == null) {
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
        while (goalType == null || goalType.isEmpty()) {
            System.out.println("Enter Goal Type : ");
            goalType = sc.next();
        }

        while (targetValue == null) {
            System.out.println("Enter target value : ");
            targetValue = sc.nextDouble();
        }
        while (currentValue == null) {
            System.out.println("Enter current value : ");
            currentValue = sc.nextDouble();
        }
        while (true) {
            System.out.println("Enter Date (yyyy-MM-dd): ");
            String dateStr = sc.next();
            date = dateUtil.parseStringToDate(dateStr);

            if (date != null) {
                break;
            } else {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
        ActivityGoal activityGoal = new ActivityGoal(id, user, goalType, targetValue, currentValue, date);
        activityGoalRepository.Edit(activityGoal);
        System.out.println("Edit Operation for id " + id + " is successfull!!");
    }

}
