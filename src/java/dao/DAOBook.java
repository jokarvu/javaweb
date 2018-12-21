/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DatabasePackage.DBConnection;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import model.Book;

/**
 *
 * @author mito
 */
public class DAOBook {
    public static ArrayList<Book> getListBook() throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM books";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Book> list = new ArrayList<>();
        while(rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setSlug(rs.getString("slug"));
            book.setAuthor(rs.getString("author"));
            book.setDes(rs.getString("des"));
            book.setCat_id(rs.getInt("cat_id"));
            book.setPrice(rs.getInt("price"));
            book.setTotal_quantity(rs.getInt("total_quantity"));
            book.setLeft_quantity(rs.getInt("left_quantity"));
            book.setCreated_at(rs.getString("created_at"));
            book.setUpdated_at(rs.getString("updated_at"));
            list.add(book);
        }
        return list;
    }
    
    public static ArrayList<Book> getBookByCon(String con) throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM books " + con;
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Book> list = new ArrayList<>();
        while(rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setSlug(rs.getString("slug"));
            book.setAuthor(rs.getString("author"));
            book.setDes(rs.getString("des"));
            book.setCat_id(rs.getInt("cat_id"));
            book.setPrice(rs.getInt("price"));
            book.setTotal_quantity(rs.getInt("total_quantity"));
            book.setLeft_quantity(rs.getInt("left_quantity"));
            book.setCreated_at(rs.getString("created_at"));
            book.setUpdated_at(rs.getString("updated_at"));
            list.add(book);
        }
        return list;
    }

    public static Book findBook(int id) throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM books WHERE id = '" + id + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Book book = new Book();
        if (rs.first()) {
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setSlug(rs.getString("slug"));
            book.setAuthor(rs.getString("author"));
            book.setDes(rs.getString("des"));
            book.setCat_id(rs.getInt("cat_id"));
            book.setPrice(rs.getInt("price"));
            book.setTotal_quantity(rs.getInt("total_quantity"));
            book.setLeft_quantity(rs.getInt("left_quantity"));
            book.setCreated_at(rs.getString("created_at"));
            book.setUpdated_at(rs.getString("updated_at"));
        }
        return book;
    }



    public static void main(String[] args) throws SQLException 
    {
        //
    }
}
