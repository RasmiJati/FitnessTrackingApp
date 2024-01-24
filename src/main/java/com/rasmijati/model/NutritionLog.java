/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author rasmi
 */
public class NutritionLog implements IEntity{
    private Long id;
    private User user;
    private String mealType;
    private List<String> foodItems;
    private List<Double> portionSizes;
   private String caloriesConsumed;
   private LocalDate dateLogged;

    public NutritionLog() {
    }

    public NutritionLog(Long id, User user, String mealType, List<String> foodItems, List<Double> portionSizes, String caloriesConsumed, LocalDate dateLogged) {
        this.id = id;
        this.user = user;
        this.mealType = mealType;
        this.foodItems = foodItems;
        this.portionSizes = portionSizes;
        this.caloriesConsumed = caloriesConsumed;
        this.dateLogged = dateLogged;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public List<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<String> foodItems) {
        this.foodItems = foodItems;
    }

    public List<Double> getPortionSizes() {
        return portionSizes;
    }

    public void setPortionSizes(List<Double> portionSizes) {
        this.portionSizes = portionSizes;
    }

    public String getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(String caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public LocalDate getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(LocalDate dateLogged) {
        this.dateLogged = dateLogged;
    }

    @Override
    public String toString() {
        return "NutritionLog{" + "id=" + id + ", user=" + user + ", mealType=" + mealType + ", foodItems=" + foodItems + ", portionSizes=" + portionSizes + ", caloriesConsumed=" + caloriesConsumed + ", dateLogged=" + dateLogged + '}';
    }
   
}
