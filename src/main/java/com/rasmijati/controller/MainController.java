/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.rasmijati.controller;

import com.rasmijati.model.Gender;
import com.rasmijati.model.User;
import java.sql.Date;

/**
 *
 * @author rasmi
 */
public class MainController {

    public static void main(String[] args) {
        UserController userController = new UserController();
        User u = new User(1L, "rasmi", "rasmi", "rasmi@gmail.com", Date.valueOf("2055-04-05"), Gender.FEMALE);
        userController.createUser(u);
        userController.showUser();
    }
}
