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
public class TransicionarRequest  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String estadoOrigen;
    private String estadoDestino;
    private String idHabitacion;

    public String getEstadoOrigen() {
        return estadoOrigen;
    }

    public void setEstadoOrigen(String estadoOrigen) {
        this.estadoOrigen = estadoOrigen;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

   
    

}
