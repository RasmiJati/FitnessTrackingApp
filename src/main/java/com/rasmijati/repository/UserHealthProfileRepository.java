/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import com.rasmijati.model.UserHealthProfile;
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
public class UserHealthProfileRepository extends AbstractRepository<UserHealthProfile> {

    /**
     *
     * @param userHealthProfile
     */
    @Override
    public void Create(UserHealthProfile userHealthProfile) {
        try {
            Connection con = connectDB();
            String insert = "insert into userhealthprofile(user,weight,height,bmi,bp,heartrate) value(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setLong(1, userHealthProfile.getUser().getId());
            stmt.setDouble(2, userHealthProfile.getWeight());
            stmt.setDouble(3, userHealthProfile.getHeight());
            stmt.setDouble(4, userHealthProfile.getBmi());
            stmt.setString(5, userHealthProfile.getBp());
            stmt.setBigDecimal(6, userHealthProfile.getHeartrate());

            int i = stmt.executeUpdate();
            System.out.println("Insert Operation Successfull!!");

        } catch (SQLException e) {
            System.out.println("Operation Failed !!");
        }
    }

    @Override
    public List<UserHealthProfile> Show() {
        List<UserHealthProfile> list = new ArrayList<>();
        try {
            Connection con = connectDB();
            String query = "select *from userhealthprofile ";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UserHealthProfile userHealthProfile = new UserHealthProfile(rs.getLong(1), new User(rs.getLong(2)), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getBigDecimal(7));
                list.add(userHealthProfile);
            }
        } catch (SQLException e) {
            System.out.println("Operation Failed !!!");
        }
        return list;
    }

    @Override
    public UserHealthProfile ShowById(Long id) {
        UserHealthProfile userHealthProfile = new UserHealthProfile();
        try {
            Connection con = connectDB();
            String query = "select *from userhealthprofile where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                userHealthProfile = new UserHealthProfile(rs.getLong(1), new User(rs.getLong(2)), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getBigDecimal(7));
            }

        } catch (SQLException e) {
            System.out.println("Operation Failed !!!");
        }
        return userHealthProfile;
    }

    @Override
    public void Delete(UserHealthProfile userHealthProfile) {
        try {
            Connection con = connectDB();
            String delete = "delete from userhealthprofile where id = ?";
            PreparedStatement stmt = con.prepareStatement(delete);
            stmt.setLong(1, userHealthProfile.getId());
            int i = stmt.executeUpdate();
            System.out.println(" Delete Operation successfull!!");
            con.close();

        } catch (SQLException e) {
            System.out.println(" Operation failed!!!");
        }
    }

    @Override
    public void Edit(UserHealthProfile userHealthProfile) {
        try {
            Connection con = connectDB();
            String edit = "update userhealthprofile set user = ? ,weight = ? ,height = ? ,bmi = ? ,bp = ? ,heartrate = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(edit);
            stmt.setLong(1, userHealthProfile.getUser().getId());
            stmt.setDouble(2, userHealthProfile.getWeight());
            stmt.setDouble(3, userHealthProfile.getHeight());
            stmt.setDouble(4, userHealthProfile.getBmi());
            stmt.setString(5, userHealthProfile.getBp());
            stmt.setBigDecimal(6, userHealthProfile.getHeartrate());
            stmt.setLong(7, userHealthProfile.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Update operation successfull!!");
        } catch (SQLException e) {
            System.out.println("Operation Failed!!!");
        }
    }
}
