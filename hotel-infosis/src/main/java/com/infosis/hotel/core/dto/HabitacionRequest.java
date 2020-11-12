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
public class HabitacionRequest  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String estado;
    private String tipo;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

}
