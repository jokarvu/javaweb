/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DatabasePackage.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mito
 */
public class DAODashboard {
    public static Map<String, String> counter() throws SQLException
    {
        Map<String, String> result = new HashMap<String, String>();
        Connection connection = DBConnection.getConnection();
        // User count
        String sql = "SELECT COUNT(id) FROM users";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        String user_count = "0";
        if(rs.first()) {
            user_count = rs.getString("COUNT(id)");
        }
        result.put("user_count", user_count);
        // Book count
        sql = "SELECT COUNT(id) FROM books";
        ps = connection.prepareCall(sql);
        rs = ps.executeQuery();
        String book_count = "0";
        if(rs.first()) {
            book_count = rs.getString("COUNT(id)");
        }
        result.put("book_count", book_count);
        // Invoice count
        sql = "SELECT COUNT(id) FROM invoices";
        ps = connection.prepareCall(sql);
        rs = ps.executeQuery();
        String invoice_count = "0";
        if(rs.first()) {
            invoice_count = rs.getString("COUNT(id)");
        }
        result.put("invoice_count", invoice_count);
        // Category count
        sql = "SELECT COUNT(id) FROM categories";
        ps = connection.prepareCall(sql);
        rs = ps.executeQuery();
        String category_count = "0";
        if(rs.first()) {
            category_count = rs.getString("COUNT(id)");
        }
        result.put("category_count", category_count);
        // Total sold books
        sql = "SELECT SUM(quantity) as total_sold_books FROM book_invoice";
        ps = connection.prepareCall(sql);
        rs = ps.executeQuery();
        String total_sold_books = "0";
        if(rs.first()) {
            total_sold_books = rs.getString("total_sold_books");
        }
        result.put("total_sold_books", total_sold_books);
        // Total money
        sql = "SELECT SUM(quantity*invoice_price) as total_money FROM book_invoice";
        ps = connection.prepareCall(sql);
        rs = ps.executeQuery();
        String total_money = "0";
        if(rs.first()) {
            total_money = rs.getString("total_money");
        }
        result.put("total_money", total_money);
        // Total left books
        sql = "SELECT SUM(quantity) as total_left_books FROM books";
        ps = connection.prepareCall(sql);
        rs = ps.executeQuery();
        String total_left_books = "0";
        if(rs.first()) {
            total_left_books = rs.getString("total_left_books");
        }
        result.put("total_left_books", total_left_books);
        // Return result
        return result;
    }

    public static void main(String[] args) throws SQLException 
    {
        for(String name: DAODashboard.counter().keySet()) {
            System.out.println(name + " : " + DAODashboard.counter().get(name));
        }
    }
}
