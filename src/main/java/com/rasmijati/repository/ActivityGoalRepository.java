/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.ActivityGoal;
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
public class ActivityGoalRepository extends AbstractRepository<ActivityGoal> {

    @Override
    public void Create(ActivityGoal activityGoal) {
        try {
            Connection con = connectDB();
            String query = "insert into activitygoal(user,goaltype,targetvalue,currentvalue,date) value(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, activityGoal.getUser().getId());
            stmt.setString(2, activityGoal.getGoalType());
            stmt.setDouble(3, activityGoal.getTargetValue());
            stmt.setDouble(4, activityGoal.getCurrentValue());
            stmt.setDate(5, new java.sql.Date(activityGoal.getDate().getTime()));
            stmt.executeUpdate();
            System.out.println("Create Operation Successfull!!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
    }

    @Override
    public List<ActivityGoal> Show() {
        List<ActivityGoal> list = new ArrayList<>();
        try {
            Connection con = connectDB();
            String query = "select *from activitygoal";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ActivityGoal activityGoal = new ActivityGoal(rs.getLong(1), new User(rs.getLong(2)), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6));
                list.add(activityGoal);
            }
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
        return list;
    }

    @Override
    public ActivityGoal ShowById(Long id) {
        ActivityGoal activityGoal = new ActivityGoal();
        try {
            Connection con = connectDB();
            String query = "select *from activitygoal where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                activityGoal = new ActivityGoal(rs.getLong(1), new User(rs.getLong(2)), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6));
            }
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
        return activityGoal;
    }

    @Override
    public void Delete(ActivityGoal activityGoal) {
        try {
            Connection con = connectDB();
            String query = "delete from activitygoal where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, activityGoal.getId());
            stmt.executeUpdate();
            System.out.println("Delete Operation Succesfull!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
    }

    @Override
    public void Edit(ActivityGoal activityGoal) {
        try {
            Connection con = connectDB();
            String query = "update activitygoal set user=? , goaltype = ? ,targetvalue = ? ,currentvalue = ? ,date = ? where id =?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, activityGoal.getUser().getId());
            stmt.setString(2, activityGoal.getGoalType());
            stmt.setDouble(3, activityGoal.getTargetValue());
            stmt.setDouble(4, activityGoal.getCurrentValue());
            stmt.setDate(5, new java.sql.Date(activityGoal.getDate().getTime()));
            stmt.setLong(6, activityGoal.getId());
            stmt.executeUpdate();
            System.out.println("Edit Operation Succesfull!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!");
        }
    }
}
