/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmi
 */
public class UserRepository extends AbstractRepository<User> {

    @Override
    public void Create(User u) {

        try {
            Connection con = connectDB();
            String insert = "insert into user(name,email,password,birth_date,gender) value(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getBirthdate());
            stmt.setString(5, u.getGender());

            int i = stmt.executeUpdate();
            System.out.println(i + " Insert Operation successfull!!");

        } catch (SQLException e) {
            System.out.println("Insert Operation failed!!!");
        }
    }

    @Override
    public List<User> Show() {
        List<User> list = new ArrayList<>();
        try {
            Connection con = connectDB();
            String query = "select *from user";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Failed to Show!!!");
        }
        return list;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public User ShowById(Long id) {
        User user = new User();
        try {
            Connection con = connectDB();
            String query = "select *from user where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
        } catch (SQLException e) {
            System.out.println("Failed to show!!!");
        }
        return user;
    }

    @Override
    public void Delete(User u) {
        try {
            Connection con = connectDB();
            String delete = "delete from user where id = ?";
            PreparedStatement stmt = con.prepareStatement(delete);
            stmt.setLong(1, u.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Delete Operation successfull!!");
            con.close();

        } catch (SQLException e) {
            System.out.println("Delete Operation failed!!!");
        }
    }

    @Override
    public void Edit(User u) {
        try {
            Connection con = connectDB();
            String edit = "update user set name = ? , email = ? , password = ? , birth_date = ? , gender = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(edit);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getBirthdate());
            stmt.setString(5, u.getGender());
            stmt.setLong(6, u.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Update operation successfull!!");
        } catch (SQLException e) {
            System.out.println("Failed to edit!!!");
        }
    }
}
