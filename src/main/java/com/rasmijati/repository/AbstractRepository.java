/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.IEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmi
 * @param <T>
 */
public class AbstractRepository<T extends IEntity> {

    private List<T> list;

    public Connection connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FitnessTracker", "root", "Root@1234");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed!!");
        }
        return null;
    }

    public AbstractRepository() {
        list = new ArrayList();
    }

    public void Create(T t) {
        this.list.add(t);
    }

    public List<T> Show() {
        return list;
    }

    public T ShowById(Long id) {
        for (T t : list) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public void Delete(T t) {
        this.list.remove(t);
    }

    public void Edit(T t) {
    }
}
