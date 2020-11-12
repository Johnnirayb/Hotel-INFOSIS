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
public class ReservarRequest  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cantidadPersonas;
    private String idHabitacion;

    public String getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(String cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

     
    

}
