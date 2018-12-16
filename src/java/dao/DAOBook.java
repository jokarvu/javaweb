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
import model.Book;

/**
 *
 * @author mito
 */
public class DAOBook {
    public ArrayList<Book> getListBook() throws SQLException
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
    
    public ArrayList<Book> getBookByCon(String con) throws SQLException
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

    public static void main(String[] args) throws SQLException 
    {
        DAOBook dao = new DAOBook();
        for(Book ds : dao.getListBook()) {
            System.out.println(ds.getId() + " - " + ds.getName());
        }
    }
}
