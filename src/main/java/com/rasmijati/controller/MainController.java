/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.rasmijati.controller;

import com.rasmijati.repository.ActivityGoalRepository;
import com.rasmijati.repository.HealthMetricRepository;
import com.rasmijati.repository.NutritionLogRepository;
import com.rasmijati.repository.PhysicalActivityRepository;
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
        HealthMetricController healthMetricController = new HealthMetricController();
        HealthMetricRepository healthMetricRepository = new HealthMetricRepository();
        PhysicalActivityController physicalActivityController = new PhysicalActivityController();
        PhysicalActivityRepository physicalActivitryRepository = new PhysicalActivityRepository();
        NutritionLogController nutritionLogController = new NutritionLogController();
        NutritionLogRepository nutritionLogRepository = new NutritionLogRepository();
        ActivityGoalController activityGoalController = new ActivityGoalController();
        ActivityGoalRepository activityGoalRepository = new ActivityGoalRepository();
        String choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println();
            System.out.println("############## Select an Operation #############");
            System.out.println();
            System.out.println("Enter 1 for User : ");
            System.out.println("Enter 2 for User Health Profile : ");
            System.out.println("Enter 3 for Health Metric : ");
            System.out.println("Enter 4 for Physical Activity : ");
            System.out.println("Enter 5 for Nutrition Log : ");
            System.out.println("Enter 6 for Activity Goal : ");
            System.out.println("Enter 7 for exit : ");
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
                    healthMetricController.Options(healthMetricRepository, userRepository);
                    break;
                case "4":
                    physicalActivityController.Options(physicalActivitryRepository, userRepository);
                    break;
                case "5":
                    nutritionLogController.Options(nutritionLogRepository, userRepository);
                case "6":
                    activityGoalController.Options(activityGoalRepository, userRepository);
                case "7":
                    return;
                default:
                    System.out.println("Invalid Option!!");
                    break;
            }
        } while (!choice.equals("0"));
    }
}
