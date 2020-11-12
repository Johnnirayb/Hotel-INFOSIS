/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosis.hotel.core.dto;

import java.math.BigDecimal;


/**
 *
 * @author Johnniray Betancourt
 */
public class HabitacionResponse{

    String id;
    String nombre;
    String tipo;
    String ocupantes;
    String estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public HabitacionResponse() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(String ocupantes) {
        this.ocupantes = ocupantes;
    }
    
    
    public HabitacionResponse(String id,String nombre,String tipo,String ocupantes,String estado) {
        this.estado = estado;
        this.nombre = nombre;
        this.ocupantes = ocupantes;
        this.tipo= tipo;
        this.id= id;
    }

    
}
