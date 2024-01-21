/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.model;

import java.sql.Date;

/**
 *
 * @author rasmi
 */
public class User {

    private Long id;
    private String name;
    private String password;
    private String email;
    private Date birthdate;
    private String gender;

    public User() {
    }

    public User(Long id, String name, String password, String email, Date birthdate, String gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " password: " + password + " email: " + email + " DOB: " + birthdate + " Gender: " + gender;
    }
}
