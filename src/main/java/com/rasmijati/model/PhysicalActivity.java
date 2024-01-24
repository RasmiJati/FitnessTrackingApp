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
public class PhysicalActivity implements IEntity {

    private Long id;
    private User user;
    private String activitytype;
    private String duration;
    private String caloriesburned;
    private LocalDate datelogged;

    public PhysicalActivity() {
    }

    public PhysicalActivity(Long id, User user, String activitytype, String duration, String caloriesburned, LocalDate datelogged) {
        this.id = id;
        this.user = user;
        this.activitytype = activitytype;
        this.duration = duration;
        this.caloriesburned = caloriesburned;
        this.datelogged = datelogged;
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

    public String getActivitytype() {
        return activitytype;
    }

    public void setActivitytype(String activitytype) {
        this.activitytype = activitytype;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCaloriesburned() {
        return caloriesburned;
    }

    public void setCaloriesburned(String caloriesburned) {
        this.caloriesburned = caloriesburned;
    }

    public LocalDate getDatelogged() {
        return datelogged;
    }

    public void setDatelogged(LocalDate datelogged) {
        this.datelogged = datelogged;
    }

    @Override
    public String toString() {
        return "PhysicalActivity{" + "id=" + id + ", user=" + user + ", activitytype=" + activitytype + ", duration=" + duration + ", caloriesburned=" + caloriesburned + ", datelogged=" + datelogged + '}';
    }

}
