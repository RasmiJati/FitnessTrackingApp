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
public class HealthMetric implements IEntity {

    private Long id;
    private User user;
    private String MetricType;
    private Double value;
    private LocalDate datelogged;

    public HealthMetric() {
    }

    public HealthMetric(Long id, User user, String MetricType, Double value, LocalDate datelogged) {
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

    public LocalDate getDatelogged() {
        return datelogged;
    }

    public void setDatelogged(LocalDate datelogged) {
        this.datelogged = datelogged;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.MetricType);
        hash = 29 * hash + Objects.hashCode(this.value);
        hash = 29 * hash + Objects.hashCode(this.datelogged);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HealthMetric)) {
            return false;
        }
        final HealthMetric other = (HealthMetric) obj;
        if (!Objects.equals(this.MetricType, other.MetricType)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return Objects.equals(this.datelogged, other.datelogged);
    }

    @Override
    public String toString() {
        return "HealthMetric{" + "id=" + id + ", user=" + user + ", MetricType=" + MetricType + ", value=" + value + ", datelogged=" + datelogged + '}';
    }

}
