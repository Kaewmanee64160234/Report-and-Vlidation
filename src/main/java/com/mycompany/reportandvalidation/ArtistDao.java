/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reportandvalidation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ArtistDao implements Dao<ArtistReport> {

    @Override
    public ArtistReport get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ArtistReport> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArtistReport save(ArtistReport obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArtistReport update(ArtistReport obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ArtistReport obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ArtistReport> getAll(String where, String order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ArtistReport> getTopTenArtistByTotalPrice() {
        ArrayList<ArtistReport> list = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.getConnect();
            Statement stm = conn.createStatement();
            String sql = "SELECT art.*, SUM(ini.UnitPrice) TotalQuantity, SUM(ini.UnitPrice*ini.Quantity) as TotalPrice FROM artists art "+
            "INNER JOIN albums alb ON alb.ArtistId=art.ArtistId "+
           " INNER JOIN tracks tra ON tra.AlbumId=alb.AlbumId "+
            "INNER JOIN invoice_items ini ON ini.TrackId=tra.TrackId "+
           " INNER JOIN invoices inv ON inv.InvoiceId=ini.InvoiceId "+
            "GROUP BY art.ArtistId "+
           "ORDER BY TotalPrice DESC LIMIT 10";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ArtistReport artist =  ArtistReport.fromRS(rs);
                list.add(artist);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArtistDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
