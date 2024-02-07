/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.NutritionLog;
import com.rasmijati.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rasmi
 */
public class NutritionLogRepository extends AbstractRepository<NutritionLog> {

    @Override
    public void Create(NutritionLog nutritionLog) {
        try {
            Connection con = connectDB();
            List<Double> portionSizes = nutritionLog.getPortionSizes();

            String portionSizesString = portionSizes.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            
            String query = "insert into nutritionallog(user,mealtype,fooditems,portionsize,caloriesconsumed,datelogged) value(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, nutritionLog.getUser().getId());
            stmt.setString(2, nutritionLog.getMealType());
            stmt.setString(3, String.join(",", nutritionLog.getFoodItems()));
            stmt.setString(4, portionSizesString);
            stmt.setString(5, nutritionLog.getCaloriesConsumed());
            stmt.setDate(6, new java.sql.Date(nutritionLog.getDateLogged().getTime()));
            stmt.executeUpdate();
            System.out.println("Create Operation Successfull!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
            e.printStackTrace(); // Print the exception details

        }
    }

    @Override
    public List<NutritionLog> Show() {
        List<NutritionLog> list = new ArrayList<>();
        try {
            Connection con = connectDB();
            String query = "select *from nutritionallog";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] stringArray = rs.getString(4).split(",");
                Double[] doubleArray = Arrays.stream(rs.getString(5).split(","))
                        .map(Double::parseDouble)
                        .toArray(Double[]::new);

                NutritionLog nutritionLog = new NutritionLog(rs.getLong(1), new User(rs.getLong(2)), rs.getString(3), new ArrayList<>(Arrays.asList(stringArray)),
                        new ArrayList<>(Arrays.asList(doubleArray)), rs.getString(6), rs.getDate(7));
                list.add(nutritionLog);
            }
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
        return list;
    }

    @Override
    public NutritionLog ShowById(Long id) {
        NutritionLog nutritionLog = new NutritionLog();
        try {
            Connection con = connectDB();
            String query = "select *from nutritionallog where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] stringArray = rs.getString(4).split(",");
                Double[] doubleArray = Arrays.stream(rs.getString(5).split(","))
                        .map(Double::parseDouble)
                        .toArray(Double[]::new);

                nutritionLog = new NutritionLog(rs.getLong(1), new User(rs.getLong(2)), rs.getString(3), new ArrayList<>(Arrays.asList(stringArray)),
                        new ArrayList<>(Arrays.asList(doubleArray)), rs.getString(6), rs.getDate(7));

            }
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
        return nutritionLog;
    }

    @Override
    public void Delete(NutritionLog nutritionLog) {
        try {
            Connection con = connectDB();
            String query = "delete from nutritionallog where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, nutritionLog.getId());
            stmt.executeUpdate();
            System.out.println("Delete Operation Successfull!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
    }

    @Override
    public void Edit(NutritionLog nutritionLog) {
        try {
            Connection con = connectDB();
            // Assuming nutritionLog.getPortionSizes() returns a List<Double>
            List<Double> portionSizes = nutritionLog.getPortionSizes();
            // Convert the list of Double values to a comma-separated string
            String portionSizesString = portionSizes.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));

            String query = "update nutritionallog set user = ? ,mealtype = ? ,fooditems = ? ,portionsize = ? ,caloriesconsumed = ? ,datelogged = ?  where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, nutritionLog.getUser().getId());
            stmt.setString(2, nutritionLog.getMealType());
            //stmt.setString(3, nutritionLog.getFoodItems().toString());
            stmt.setString(3, String.join(",", nutritionLog.getFoodItems()));
            // Set the string parameter in the PreparedStatement
            stmt.setString(4, portionSizesString);

            stmt.setString(5, nutritionLog.getCaloriesConsumed());
            stmt.setDate(6, new java.sql.Date(nutritionLog.getDateLogged().getTime()));
            stmt.setLong(7, nutritionLog.getId());
            stmt.executeUpdate();
            System.out.println("Edit Operation Successfull!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
    }
}
