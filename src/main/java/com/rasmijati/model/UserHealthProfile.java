/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.math.BigDecimal;
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
@Table(name = "health_profile")
public class UserHealthProfile implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "weight", nullable = false)
    private Double weight;
    @Column(name = "height", nullable = false)
    private Double height;
    @Column(name = "bmi", nullable = false)
    private Double bmi;
    @Column(name = "bp", nullable = false, length = 50)
    private String bp;
    @Column(name = "heart_rate", nullable = false)
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
