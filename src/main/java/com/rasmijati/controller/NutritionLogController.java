/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.NutritionLog;
import com.rasmijati.model.User;
import com.rasmijati.repository.NutritionLogRepository;
import com.rasmijati.repository.UserRepository;
import com.rasmijati.util.DateUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rasmi
 */
public class NutritionLogController {

    private static UserRepository userRepository;
    private static NutritionLogRepository nutritionalLogRepository;
    private static DateUtil dateUtil = new DateUtil();

    public void Options(NutritionLogRepository nutritionalLogRepository, UserRepository userRepository) {
        this.nutritionalLogRepository = nutritionalLogRepository;
        this.userRepository = userRepository;
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println();
            System.out.println("*************Performing Operation for Nutrition Log**************");
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
        String mealType = null;
        List<String> foodItems = new ArrayList<>();
        List<Double> portionSizes = new ArrayList<>();
        String CaloriesConsumed = null;
        LocalDate datelogged = null;
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
        while (mealType == null || mealType.isEmpty()) {
            System.out.println("Enter Meal Type : ");
            mealType = sc.next();
        }

        System.out.println("Enter Food Items (enter 'exit' to finish): ");
        while (true) {
            String userInput = sc.next();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            foodItems.add(userInput);
        }

        System.out.println("Enter Portion size (enter 0 to finish ) : ");
        while (true) {
            Double userInput = sc.nextDouble();

            if (userInput.equals(0.0)) {
                break;
            }
            portionSizes.add(userInput);
        }
        while (CaloriesConsumed == null || CaloriesConsumed.isEmpty()) {
            System.out.println("Enter calories Consumed : ");
            CaloriesConsumed = sc.next();
        }
        while (true) {
            System.out.println("Enter Logged Date (yyyy-MM-dd): ");
            String dateStr = sc.next();
            datelogged = dateUtil.parseStringToDate(dateStr);

            if (datelogged != null) {
                break;
            } else {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
        NutritionLog nutritionLog = new NutritionLog(id, user, mealType, foodItems, portionSizes, CaloriesConsumed, datelogged);
        nutritionalLogRepository.Create(nutritionLog);
        System.out.println("Create operation successfull!!!!");
    }

    public static void Show() {
        System.out.println("****************Nutrition Log Information**********************");
        nutritionalLogRepository.Show().stream().forEach(x -> System.out.println(x));
        System.out.println();
    }

    public static void Delete() {
        Long id;
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------Performing Delete Operation----------------");
        System.out.println("Enter id");
        id = sc.nextLong();
        NutritionLog nutritionLog = nutritionalLogRepository.ShowById(id);
        while (nutritionLog == null) {
            System.out.println("Id " + id + " is invalid!!!");
            System.out.println("Delete for id " + id + " is failed !!!");
            return;
        }
        nutritionalLogRepository.Delete(nutritionLog);
        System.out.println("Delete Operation for id " + id + " is successfull!!!");
    }

    public static void Edit() {
        Long id = null;
        User user = null;
        String mealType = null;
        List<String> foodItems = new ArrayList<>();
        List<Double> portionSizes = new ArrayList<>();
        String CaloriesConsumed = null;
        LocalDate datelogged = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------Performing edit operation---------------");
        System.out.println("Enter id");
        id = sc.nextLong();
        NutritionLog nutritionLog = nutritionalLogRepository.ShowById(id);
        while (nutritionLog == null) {
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
        while (mealType == null || mealType.isEmpty()) {
            System.out.println("Enter Meal Type : ");
            mealType = sc.next();
        }

        System.out.println("Enter Food Items (enter 'exit' to finish): ");
        while (true) {
            String userInput = sc.next();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            foodItems.add(userInput);
        }
        System.out.println("Enter Portion size (enter 0 to finish ) : ");
        while (true) {
            Double userInput = sc.nextDouble();

            if (userInput.equals(0.0)) {
                break;
            }
            portionSizes.add(userInput);
        }
        while (CaloriesConsumed == null || CaloriesConsumed.isEmpty()) {
            System.out.println("Enter calories Consumed : ");
            CaloriesConsumed = sc.next();
        }
        while (true) {
            System.out.println("Enter Logged Date (yyyy-MM-dd): ");
            String dateStr = sc.next();
            datelogged = dateUtil.parseStringToDate(dateStr);

            if (datelogged != null) {
                break;
            } else {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
        NutritionLog nutritionslog = new NutritionLog(id, user, mealType, foodItems, portionSizes, CaloriesConsumed, datelogged);
        nutritionalLogRepository.Edit(nutritionslog);
        System.out.println("Edit Operation for id " + id + " is successfull!!");
    }

}
