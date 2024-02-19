/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.repository.UserRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rasmi
 */
@Named
@ViewScoped
public class UserController implements Serializable {

    private User user;
    private List<User> userList;

    @Inject
    private UserRepository userRepository;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @PostConstruct
    public void init() {
        this.user = new User();
        this.userList = userRepository.Show();
        System.out.println(userList.size());
    }

    public void beforeCreate() {
        this.user = new User();
    }

    public void create() {
        this.userList = userRepository.Show();
    }

    public void Show() {
        userRepository.Show();
    }

    public void ShowById(Long id) {
        userRepository.ShowById(id);
    }

    public void beforeEdit(User user) {
        this.user = userRepository.ShowById(user.getId());
    }

    public void edit() {
        userRepository.Edit(this.user);
        this.userList = userRepository.Show();
    }

    public void delete(User user) {
        userRepository.Delete(user);
        userList = userRepository.Show();
    }
}
