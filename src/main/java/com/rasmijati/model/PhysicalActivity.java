/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.util.Date;
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
@Table(name = "physical_activity")
public class PhysicalActivity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "activity_type", nullable = false, length = 50)
    private String activitytype;
    @Column(name = "duration", nullable = false, length = 50)
    private String duration;
    @Column(name = "calories_burned", nullable = false, length = 50)
    private String caloriesburned;
    @Column(name = "logged_date", nullable = false, length = 50)
    private Date datelogged;

    public PhysicalActivity() {
    }

    public PhysicalActivity(Long id, User user, String activitytype, String duration, String caloriesburned, Date datelogged) {
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

    public Date getDatelogged() {
        return datelogged;
    }

    public void setDatelogged(Date datelogged) {
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
