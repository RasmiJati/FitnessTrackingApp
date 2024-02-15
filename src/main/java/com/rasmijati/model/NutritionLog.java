/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rasmi
 */
@Entity
@Table(name = "nutritional_log")
public class NutritionLog implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "meal_type", nullable = false , length = 50)
    private String mealType;
    @Column(name = "food_items", nullable = false , length = 200)
    private List<String> foodItems;
    @Column(name = "portion_size" , nullable = false)
    private List<Double> portionSizes;
    @Column(name = "calories_consumed" , nullable = false, length = 50)
    private String caloriesConsumed;
    @Column(name = "logged_date" , nullable = false)
    private Date dateLogged;

    public NutritionLog() {
    }

    public NutritionLog(Long id, User user, String mealType, List<String> foodItems, List<Double> portionSizes, String caloriesConsumed, Date dateLogged) {
        this.id = id;
        this.user = user;
        this.mealType = mealType;
        this.foodItems = foodItems;
        this.portionSizes = portionSizes;
        this.caloriesConsumed = caloriesConsumed;
        this.dateLogged = dateLogged;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    public Date getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(Date dateLogged) {
        this.dateLogged = dateLogged;
    }

    /**
     *
     * @return
     */
    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.mealType);
        hash = 29 * hash + Objects.hashCode(this.foodItems);
        hash = 29 * hash + Objects.hashCode(this.portionSizes);
        hash = 29 * hash + Objects.hashCode(this.caloriesConsumed);
        hash = 29 * hash + Objects.hashCode(this.dateLogged);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NutritionLog)) {
            return false;
        }
        final NutritionLog other = (NutritionLog) obj;
        if (!Objects.equals(this.mealType, other.mealType)) {
            return false;
        }
        if (!Objects.equals(this.caloriesConsumed, other.caloriesConsumed)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.foodItems, other.foodItems)) {
            return false;
        }
        if (!Objects.equals(this.portionSizes, other.portionSizes)) {
            return false;
        }
        return Objects.equals(this.dateLogged, other.dateLogged);
    }

    @Override
    public String toString() {
        return "NutritionLog{" + "id=" + id + ", user=" + user + ", mealType=" + mealType + ", foodItems=" + foodItems + ", portionSizes=" + portionSizes + ", caloriesConsumed=" + caloriesConsumed + ", dateLogged=" + dateLogged + '}';
    }

}
