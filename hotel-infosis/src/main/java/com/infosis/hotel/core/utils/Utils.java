/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosis.hotel.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Johnniray Betancourt
 */
@Service
public class Utils {
    private static final Logger LOG = Logger.getLogger(Utils.class);
    
    
    public  String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        Date f = new Date();
        String fecha = sdf.format(f);
        return fecha;
    }
 
}
