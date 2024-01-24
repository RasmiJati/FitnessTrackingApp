/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.util.Date;






/**
 *
 * @author rasmi
 */
public class HealthMetric implements IEntity {

    private Long id;
    private User user;
    private String MetricType;
    private Double value;
    private Date datelogged;

    public HealthMetric() {
    }

    public HealthMetric(Long id, User user, String MetricType, Double value, Date datelogged) {
        this.id = id;
        this.user = user;
        this.MetricType = MetricType;
        this.value = value;
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

    public String getMetricType() {
        return MetricType;
    }

    public void setMetricType(String MetricType) {
        this.MetricType = MetricType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDatelogged() {
        return datelogged;
    }

    public void setDatelogged(Date datelogged) {
        this.datelogged = datelogged;
    }

    @Override
    public String toString() {
        return "HealthMetric{" + "id=" + id + ", user=" + user + ", MetricType=" + MetricType + ", value=" + value + ", datelogged=" + datelogged + '}';
    }

}
