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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rasmi
 */
@Entity
@Table(name = "activity_goal")
public class ActivityGoal implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;
    @ManyToOne
    @Column(name = "user_id" , nullable = false)
    private User user;
    @Column(name = "goal_type" , nullable = false , length = 50)
    private String goalType;
    @Column(name = "target_value" , nullable = false)
    private Double targetValue;
    @Column(name = "current_value" , nullable = false)
    private Double currentValue;
    @Column(name = "date" , nullable = false)
    private Date date;

    public ActivityGoal() {
    }

    public ActivityGoal(Long id, User user, String goalType, Double targetValue, Double currentValue, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.user);
        hash = 43 * hash + Objects.hashCode(this.goalType);
        hash = 43 * hash + Objects.hashCode(this.targetValue);
        hash = 43 * hash + Objects.hashCode(this.currentValue);
        hash = 43 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityGoal)) {
            return false;
        }
        final ActivityGoal other = (ActivityGoal) obj;
        if (!Objects.equals(this.goalType, other.goalType)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.targetValue, other.targetValue)) {
            return false;
        }
        if (!Objects.equals(this.currentValue, other.currentValue)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "ActivityGoal{" + "id=" + id + ", user=" + user + ", goalType=" + goalType + ", targetValue=" + targetValue + ", currentValue=" + currentValue + ", date=" + date + '}';
    }

}
