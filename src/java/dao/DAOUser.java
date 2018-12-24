/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DatabasePackage.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

/**
 *
 * @author mito
 */
public class DAOUser {
    public static ArrayList<User> getListUser() throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM users";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> list = new ArrayList<>();
        while(rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getInt("role"));
            user.setPassword(rs.getString("password"));
            user.setCreated_at(rs.getString("created_at"));
            user.setUpdated_at(rs.getString("updated_at"));
            list.add(user);
        }
        return list;
    }
    
    public static User find(int id) throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE id=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        User user = new User();
        if(rs.first()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getInt("role"));
            user.setPassword(rs.getString("password"));
            user.setCreated_at(rs.getString("created_at"));
            user.setUpdated_at(rs.getString("updated_at"));
        }
        return user;
    }

    public ArrayList<User> getUserByCon(String con) throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM users " + con;
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> list = new ArrayList<>();
        while(rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setRole(rs.getInt("role"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setCreated_at(rs.getString("created_at"));
            user.setUpdated_at(rs.getString("updated_at"));
            list.add(user);
        }
        return list;
    }
    
    public static void createUser(User user) throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        if(user.getRole() == 0) {
            user.setRole(2);
        }
        String sql = "INSERT INTO users(username, email, password, role) VALUES(?,?,?,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());
        ps.setInt(4, user.getRole());
        ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException 
    {
        User user = new User();
        user.setUsername("kalenz");
        user.setEmail("kalenz@shop.com");
        user.setPassword("1234");
        if (user.getRole() == 0) {
            System.out.print(user.getRole());
        } else {
            System.out.print("ok");
        }
    }
}
