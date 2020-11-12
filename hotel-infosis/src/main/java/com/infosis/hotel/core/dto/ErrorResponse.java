/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosis.hotel.core.dto;

import java.io.Serializable;


/**
 *
 * @author Johnniray Betancourt
 */

public class ErrorResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String code;
    private String message;
    private String fecha;
    
        
    public ErrorResponse(String code,String message,String fecha){
        this.code=code;
        this.message=message;
        this.fecha=fecha;
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

 
    
}
