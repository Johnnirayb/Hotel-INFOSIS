/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosis.hotel.core.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johnniray Betancourt
 */
@Entity
@Table(name = "PRUEBA_HABITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "findDate", query = "SELECT p FROM HabitacionEntity p WHERE p.id = :id")
    , @NamedQuery(name = "findhabitacion", query = "SELECT p FROM HabitacionEntity  p WHERE p.id = :id")})
public class HabitacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="HOTEL_SERVICE_SEQ", sequenceName="HOTEL_SEQ",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOTEL_SERVICE_SEQ")
    @Column(name = "ID")
    private BigDecimal id;
   
    @Column(name = "NOMBRE",length = 20)
    private String nombre;
   
    @Column(name = "TIPO")
    private BigDecimal  tipo;
    
    @Column(name = "ESTADO")
    private BigDecimal  estado;
    
    @Column(name = "ACTIVO")
    private BigDecimal  activo;
   

    public HabitacionEntity() {
    }

    public HabitacionEntity(BigDecimal id) {
        this.id = id;
    }
    public HabitacionEntity(BigDecimal estado,String nombre,BigDecimal tipo,BigDecimal estatus) {
        this.estado = estado;
        this.nombre = nombre;
        this.tipo= tipo;
        this.activo= estatus;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getTipo() {
        return tipo;
    }

    public void setTipo(BigDecimal tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getEstado() {
        return estado;
    }

    public void setEstado(BigDecimal estado) {
        this.estado = estado;
    }

    public BigDecimal getActivo() {
        return activo;
    }

    public void setActivo(BigDecimal activo) {
        this.activo = activo;
    }

     
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabitacionEntity)) {
            return false;
        }
        HabitacionEntity other = (HabitacionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosis.hotel.core.entities.HabitacionEntity[ id=" + id + " ]";
    }
    
}
