package com.infosis.hotel.core.services.interfaces;

import com.infosis.hotel.core.entities.HabitacionEntity;
import java.math.BigDecimal;


/**
 *
 * @author Johnniray Betancourt
 */

public interface ICrudHabitaciones<T,M> {
    
    public M getHabitaciones(String id,String valor2);
    
    public BigDecimal saveHabitacion(HabitacionEntity T);

    public M queryHabitacion(String id);

    public T updateHabitacion(HabitacionEntity T);

    public T deleteHabitacion(String T);
    
    public String transicionar(String a,String b,String c);
    
    public String reservar(String a,String c);  
    
    public String validar(String a,String c);  

}
