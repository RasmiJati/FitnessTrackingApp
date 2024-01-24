/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.time.LocalDate;

/**
 *
 * @author rasmi
 */
public class ActivityGoal implements IEntity{
    private Long id;
    private User user;
    private String goalType;
    private Double targetValue;
    private Double currentValue;
    private LocalDate date;

    public ActivityGoal() {
    }

    public ActivityGoal(Long id, User user, String goalType, Double targetValue, Double currentValue, LocalDate date) {
        this.id = id;
        this.user = user;
        this.goalType = goalType;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
        this.date = date;
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

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public Double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Double targetValue) {
        this.targetValue = targetValue;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ActivityGoal{" + "id=" + id + ", user=" + user + ", goalType=" + goalType + ", targetValue=" + targetValue + ", currentValue=" + currentValue + ", date=" + date + '}';
    }
    
}
