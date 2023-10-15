/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reportandvalidation;

import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class ArtistReport {
    private int id;
    private String name;
    private int totalPrice;
    private int totalQuantity;

    public ArtistReport(int id, String name, int totalPrice, int TotalQuantity) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.totalQuantity = TotalQuantity;
    }

    public ArtistReport(String name, int totalPrice, int TotalQuantity) {
        this.id = -1;
        this.name = name;
        this.totalPrice = totalPrice;
        this.totalQuantity = TotalQuantity;
    }

    public ArtistReport() {
         this.id = -1;
        this.name = "";
        this.totalPrice = 0;
        this.totalQuantity = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    

    public static ArtistReport fromRS(ResultSet rs){
        try{
            ArtistReport artistReport = new ArtistReport();
            artistReport.setId(rs.getInt("ArtistId"));
            artistReport.setName(rs.getString("Name"));
            artistReport.setTotalPrice(rs.getInt("TotalPrice"));
            artistReport.setTotalQuantity(rs.getInt("TotalQuantity"));
            return artistReport;
        }catch(Exception e){
            return null;
        }
    }
    
    
    
    
    
}
