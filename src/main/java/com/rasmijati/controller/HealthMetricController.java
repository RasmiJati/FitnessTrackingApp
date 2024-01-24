/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.HealthMetric;
import com.rasmijati.model.User;
import com.rasmijati.repository.HealthMetricRepository;
import com.rasmijati.repository.UserRepository;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rasmi
 */
public class HealthMetricController {

    private static HealthMetricRepository healthMetricRepository;
    private static UserRepository userRepository;

    public void Options(HealthMetricRepository healthMetricRepository, UserRepository userRepository) {
        this.healthMetricRepository = healthMetricRepository;
        this.userRepository = userRepository;
        String choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println();
            System.out.println("############## Performing operation for Health Metric #############");
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
        String metricType = null;
        Double value = null;
        Date datelogged = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Performing Create Operation------------");

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
        while (metricType == null || metricType.isEmpty()) {
            System.out.println("Enter Metric Type : ");
            metricType = sc.next();
        }
        while (value == null) {
            System.out.println("Enter Value : ");
            value = sc.nextDouble();
        }
        System.out.println("Enter Date Logged : ");
        String date = sc.next();
        datelogged = Date.valueOf(date);

        HealthMetric healthMetric = new HealthMetric(id, user, metricType, value, datelogged);
        healthMetricRepository.Create(healthMetric);
        System.out.println("Create Operation Successfull!!");
    }

    public static void Show() {
        System.out.println("**************Health Metric Information******************");
        System.out.println();
        healthMetricRepository.Show().stream().forEach(x -> System.out.println(x));
        System.out.println();
    }

    public static void Delete() {
        Long id = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Performing Delete Operation--------------");
        System.out.println("Enter id : ");
        id = sc.nextLong();
        HealthMetric healthMetric = healthMetricRepository.ShowById(id);
        if (healthMetric == null) {
            System.out.println("Id " + id + " not found !!");
            System.out.println("Delete Operation for id " + id + " is failed!!");
            return;
        }
        healthMetricRepository.Delete(healthMetric);
        System.out.println("Delete Operation for id " + id + " is successfull!!!");
    }

    public static void Edit() {
        Long id = null;
        User user = null;
        String metricType = null;
        Double value = null;
        Date datelogged = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Performing Edit Operation------------");

        System.out.println("Enter id : ");
        id = sc.nextLong();
        HealthMetric healthMetric = healthMetricRepository.ShowById(id);
        while (healthMetric == null) {
            System.out.println("Id " + id + " not found !!");
            System.out.println("Edit Operation for id " + id + " is failed!!");
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
        while (metricType == null || metricType.isEmpty()) {
            System.out.println("Enter Metric Type : ");
            metricType = sc.next();
        }
        while (value == null) {
            System.out.println("Enter Value : ");
            value = sc.nextDouble();
        }
        System.out.println("Enter Date Logged : ");
        String date = sc.next();
        datelogged = Date.valueOf(date);

        HealthMetric healthMetrics = new HealthMetric(id, user, metricType, value, datelogged);
        healthMetricRepository.Edit(healthMetrics);
        System.out.println("Edit Operation Successfull!!");
    }
}
