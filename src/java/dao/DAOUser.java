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
            user.setPassword(rs.getString("password"));
            user.setCreated_at(rs.getString("created_at"));
            user.setUpdated_at(rs.getString("updated_at"));
            list.add(user);
        }
        return list;
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
        String sql = "INSERT INTO users(username, email, password) VALUES('" + user.getUsername() + "','" + user.getEmail() +"','" + user.getPassword() + "')";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException 
    {
        User user = new User();
        user.setUsername("kalenz");
        user.setEmail("kalenz@shop.com");
        user.setPassword("1234");
        DAOUser.createUser(user);
    }
}
