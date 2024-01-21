/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.rasmijati.controller;

import com.rasmijati.repository.UserRepository;

/**
 *
 * @author rasmi
 */
public class MainController {

    public static void main(String[] args) {
        UserController userController = new UserController();
        UserRepository userRepository = new UserRepository();
        userController.Options(userRepository);
    }
}
