/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.PhysicalActivity;
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
public class PhysicalActivityRepository extends AbstractRepository<PhysicalActivity> {

    @Override
    public void Create(PhysicalActivity physicalActivity) {
        try {
            Connection con = connectDB();
            String query = "insert into physicalactivity(user,activitytype,duration,caloriesburned,datelogged) value(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, physicalActivity.getUser().getId());
            stmt.setString(2, physicalActivity.getActivitytype());
            stmt.setString(3, physicalActivity.getDuration());
            stmt.setString(4, physicalActivity.getCaloriesburned());
            stmt.setDate(5, new java.sql.Date(physicalActivity.getDatelogged().getTime()));
            stmt.executeUpdate();
            System.out.println("Insert Successfully!!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed !!!");
        }
    }

    @Override
    public List<PhysicalActivity> Show() {
        List<PhysicalActivity> list = new ArrayList<>();
        try {
            Connection con = connectDB();
            String query = "select *from physicalactivity";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PhysicalActivity physicalActivity = new PhysicalActivity(rs.getLong(1), new User(rs.getLong(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                list.add(physicalActivity);
            }
        } catch (SQLException e) {
            System.out.println("Operation Failed!!!");
        }
        return list;
    }

    @Override
    public PhysicalActivity ShowById(Long id) {
        PhysicalActivity physicalActivity = new PhysicalActivity();
        try {
            Connection con = connectDB();
            String query = "select *from physicalactivity where id = ? ";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                physicalActivity = new PhysicalActivity(rs.getLong(1), new User(rs.getLong(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
            }
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
        return physicalActivity;
    }

    @Override
    public void Delete(PhysicalActivity physicalActivity) {
        try {
            Connection con = connectDB();
            String query = "delete from physicalactivity where id = ? ";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, physicalActivity.getId());
            stmt.executeUpdate();
            System.out.println("Delete Operation Successfull!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
    }

    @Override
    public void Edit(PhysicalActivity physicalActivity) {
        try {
            Connection con = connectDB();
            String query = "update physicalactivity set user = ? , activitytype = ?, duration = ?,caloriesburned = ?, datelogged = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, physicalActivity.getUser().getId());
            stmt.setString(2, physicalActivity.getActivitytype());
            stmt.setString(3, physicalActivity.getDuration());
            stmt.setString(4, physicalActivity.getCaloriesburned());
            stmt.setDate(5, new java.sql.Date(physicalActivity.getDatelogged().getTime()));
            stmt.setLong(6, physicalActivity.getId());
            stmt.executeUpdate();
            System.out.println("Edit Operation Successfull!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
    }
}
