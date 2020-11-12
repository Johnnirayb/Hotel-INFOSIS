package com.infosis.hotel.core.services.contract;


import com.infosis.hotel.core.dto.HabitacionResponse;
import com.infosis.hotel.core.entities.HabitacionEntity;
import java.util.List;
import com.infosis.hotel.core.services.interfaces.ICrudHabitaciones;

/**
 *
 * @author Johnniray Betancourt
 */
public interface IHotelService
        extends ICrudHabitaciones<HabitacionEntity,List<HabitacionResponse>> {

}
