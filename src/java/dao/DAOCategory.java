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

import model.Category;

/**
 *
 * @author mito
 */
public class DAOCategory {
    public static ArrayList<Category> getListCategory() throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM categories";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Category> list = new ArrayList<>();
        while(rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setCreated_at(rs.getString("created_at"));
            category.setUpdated_at(rs.getString("updated_at"));
            list.add(category);
        }
        return list;
    }
    public static void main(String[] args) throws SQLException 
    {
        //
    }
}
