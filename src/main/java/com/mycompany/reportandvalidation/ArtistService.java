/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reportandvalidation;

import java.util.List;

/**
 *
 * @author USER
 */
public class ArtistService {
     public List<ArtistReport> getArtistByTotalPrice(String startDate,String stopDate){
         ArtistDao artistDao = new ArtistDao();
         return artistDao.getArtistByTotalPrice(startDate,stopDate,10);
     }
     public List<ArtistReport> getAllArtistByTotalPrice(){
         ArtistDao artistDao = new ArtistDao();
         return artistDao.getAllArtistByTotalPrice();
     }
    
}
