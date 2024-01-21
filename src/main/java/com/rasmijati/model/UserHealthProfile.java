/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.math.BigDecimal;

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

    @Override
    public String toString() {
        return "UserHealthProfile{" + "id=" + id + ", user=" + user + ", weight=" + weight + ", height=" + height + ", bmi=" + bmi + ", bp=" + bp + ", heartrate=" + heartrate + '}';
    }

}
