/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.time.LocalDate;
import java.util.Objects;

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
    public final int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.activitytype);
        hash = 97 * hash + Objects.hashCode(this.duration);
        hash = 97 * hash + Objects.hashCode(this.caloriesburned);
        hash = 97 * hash + Objects.hashCode(this.datelogged);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhysicalActivity)) {
            return false;
        }
        final PhysicalActivity other = (PhysicalActivity) obj;
        if (!Objects.equals(this.activitytype, other.activitytype)) {
            return false;
        }
        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        if (!Objects.equals(this.caloriesburned, other.caloriesburned)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return Objects.equals(this.datelogged, other.datelogged);
    }

    @Override
    public String toString() {
        return "PhysicalActivity{" + "id=" + id + ", user=" + user + ", activitytype=" + activitytype + ", duration=" + duration + ", caloriesburned=" + caloriesburned + ", datelogged=" + datelogged + '}';
    }

}
