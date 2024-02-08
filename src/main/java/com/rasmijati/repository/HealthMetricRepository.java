/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.HealthMetric;
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
public class HealthMetricRepository extends AbstractRepository<HealthMetric> {

    @Override
    public void Create(HealthMetric hm) {
        try {
            Connection con = connectDB();
            String query = "insert into healthmetric(user,metrictype,value,datelogged) value(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, hm.getUser().getId());
            stmt.setString(2, hm.getMetricType());
            stmt.setDouble(3, hm.getValue());
            stmt.setDate(4, new java.sql.Date(hm.getDatelogged().getTime()));
            int i = stmt.executeUpdate();
            System.out.println("Insert Operation Successfull!!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed !!");
        }
    }

    @Override
    public List<HealthMetric> Show() {
        List<HealthMetric> list = new ArrayList<>();
        try {
            Connection con = connectDB();
            String query = "select *from healthmetric";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HealthMetric healthMetric = new HealthMetric(rs.getLong(1), new User(rs.getLong(2)), rs.getString(3), rs.getDouble(4), rs.getDate(5));
                list.add(healthMetric);
            }
        } catch (SQLException e) {
            System.out.println("Operation Failed !!");
        }
        return list;
    }

    @Override
    public HealthMetric ShowById(Long id) {
        HealthMetric healthMetric = new HealthMetric();
        try {
            Connection con = connectDB();
            String query = "select *from healthmetric where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                healthMetric = new HealthMetric(rs.getLong(1), new User(rs.getLong(2)), rs.getString(3), rs.getDouble(4), rs.getDate(5));
            }
        } catch (SQLException e) {
            System.out.println("Operation Failed !!");
        }
        return healthMetric;
    }

    @Override
    public void Delete(HealthMetric healthMetric) {
        try {
            Connection con = connectDB();
            String query = "delete from healthmetric where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, healthMetric.getId());
            int i = stmt.executeUpdate();
            System.out.println("Delete Operation Successfull!!!");
        } catch (SQLException e) {
            System.out.println(" Operation failed!!!");
        }
    }

    @Override
    public void Edit(HealthMetric hm) {
        try {
            Connection con = connectDB();
            String query = "update healthmetric set user = ? , metrictype = ? , value = ? , datelogged = ? where id = ? ";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, hm.getUser().getId());
            stmt.setString(2, hm.getMetricType());
            stmt.setDouble(3, hm.getValue());
            stmt.setDate(4, new java.sql.Date(hm.getDatelogged().getTime()));
            stmt.setLong(5, hm.getId());
            int i = stmt.executeUpdate();
            System.out.println("Edit Operation Successfull!!");
        } catch (SQLException e) {
            System.out.println(" Operation failed!!!");

        }
    }
}
