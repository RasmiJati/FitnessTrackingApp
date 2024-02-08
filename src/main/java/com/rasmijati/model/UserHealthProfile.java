/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author rasmi
 */
public class UserHealthProfile implements IEntity{

    private Long id;
    private User user;
    private Double weight;
    private Double height;
    private Double bmi;
    private String bp;
    private BigDecimal heartrate;

    public UserHealthProfile() {
    }

    public UserHealthProfile(Long id, User user, Double weight, Double height, Double bmi, String bp, BigDecimal heartrate) {
        this.id = id;
        this.user = user;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.bp = bp;
        this.heartrate = heartrate;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public BigDecimal getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(BigDecimal heartrate) {
        this.heartrate = heartrate;
    }

    /**
     *
     * @return
     */
    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.user);
        hash = 37 * hash + Objects.hashCode(this.weight);
        hash = 37 * hash + Objects.hashCode(this.height);
        hash = 37 * hash + Objects.hashCode(this.bmi);
        hash = 37 * hash + Objects.hashCode(this.bp);
        hash = 37 * hash + Objects.hashCode(this.heartrate);
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
        if (!(obj instanceof UserHealthProfile)) {
            return false;
        }
        final UserHealthProfile other = (UserHealthProfile) obj;
        if (!Objects.equals(this.bp, other.bp)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        if (!Objects.equals(this.height, other.height)) {
            return false;
        }
        if (!Objects.equals(this.bmi, other.bmi)) {
            return false;
        }
        return Objects.equals(this.heartrate, other.heartrate);
    }

    
    @Override
    public String toString() {
        return "UserHealthProfile{" + "id=" + id + ", user=" + user + ", weight=" + weight + ", height=" + height + ", bmi=" + bmi + ", bp=" + bp + ", heartrate=" + heartrate + '}';
    }

}
