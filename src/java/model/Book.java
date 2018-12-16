/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DatabasePackage.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Invoice;
/**
 *
 * @author mito
 */
public class Book {
    private int id;
    private String name;
    private String slug;
    private String author;
    private int cat_id;
    private int total_quantity;
    private int left_quantity;
    private int price;
    private String des;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCat_id() {
        return cat_id;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public int getLeft_quantity() {
        return left_quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getDes() {
        return des;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public void setLeft_quantity(int left_quantity) {
        this.left_quantity = left_quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    
    
    public ArrayList<Invoice> getThisBookInvoices() throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT invoices.* FROM invoices LEFT JOIN book_invoice ON invoices.id = book_invoice.invoice_id LEFT JOIN books ON book_invoice.book_id = " + this.id;
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Invoice> list = new ArrayList<>();
        while(rs.next()) {
            Invoice invoice = new Invoice();
            invoice.setId(rs.getInt("id"));
            invoice.setTotal(rs.getInt("total"));
            invoice.setUser_id(rs.getInt("user_id"));
            invoice.setTotal_book(rs.getInt("total_book"));
            invoice.setShip_tax(rs.getInt("ship_tax"));
            invoice.setNote(rs.getString("note"));
            invoice.setCreated_at(rs.getString("created_at"));
            invoice.setUpdated_at(rs.getString("updated_at"));
            list.add(invoice);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        Book book = new Book();
        book.setId(1);
        for(Invoice in : book.getThisBookInvoices()) {
            System.out.println(in.getId() + " - " + in.getNote());
        }
    }

}
