/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mito
 */
public class Invoice {
    private int id;
    private int user_id;
    private int total;
    private int total_book;
    private String note;
    private int ship_tax;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_book() {
        return total_book;
    }

    public String getNote() {
        return note;
    }

    public int getShip_tax() {
        return ship_tax;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal_book(int total_book) {
        this.total_book = total_book;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setShip_tax(int ship_tax) {
        this.ship_tax = ship_tax;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
}
