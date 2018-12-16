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

import model.Invoice;

/**
 *
 * @author mito
 */
public class DAOInvoice {
    public ArrayList<Invoice> getListInvoice() throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM invoices";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Invoice> list = new ArrayList<>();
        while(rs.next()) {
            Invoice invoice = new Invoice();
            invoice.setId(rs.getInt("id"));
            invoice.setUser_id(rs.getInt("user_id"));
            invoice.setTotal(rs.getInt("total"));
            invoice.setTotal_book(rs.getInt("total_book"));
            invoice.setShip_tax(rs.getInt("ship_tax"));
            invoice.setNote(rs.getString("note"));
            invoice.setCreated_at(rs.getString("created_at"));
            invoice.setUpdated_at(rs.getString("updated_at"));
            list.add(invoice);
        }
        return list;
    }
    public static void main(String[] args) throws SQLException 
    {
        DAOInvoice dao = new DAOInvoice();
        for(Invoice ds : dao.getListInvoice()) {
            System.out.println(ds.getId() + " - " + ds.getUser_id());
        }
    }
}
