package com.infosis.hotel.core.controllers;

import com.infosis.hotel.core.dto.ErrorResponse;
import com.infosis.hotel.core.dto.HabitacionResponse;
import com.infosis.hotel.core.dto.HabitacionRequest;
import com.infosis.hotel.core.dto.ReservarRequest;
import com.infosis.hotel.core.dto.TransicionarRequest;
import com.infosis.hotel.core.entities.HabitacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.infosis.hotel.core.utils.Utils;
import com.infosis.hotel.core.services.contract.IHotelService;
import java.math.BigDecimal;
import java.util.List;


/**
 *
 * @author Johnniray Betancourt
 */

@RestController
@RequestMapping(value = "/")
public class HotelController {

    @Autowired
    IHotelService hotelService;   
  
    @Autowired
    Utils utilService;  
    
    
    
    @PostMapping(value = "/listado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getHabitaciones(
            @RequestBody HabitacionRequest habitacion,
            @RequestHeader("Rol") String rol
    ) {
        String roles = hotelService.validar("CONSULTAR", rol);
        if (roles.equals("1")) {
            List<HabitacionResponse> habitaciones = hotelService.getHabitaciones(habitacion.getEstado(), habitacion.getTipo());
            if (habitaciones.size() > 0) {
                return new ResponseEntity<List<HabitacionResponse>>(
                        habitaciones,
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        new ErrorResponse("400", "Error en consulta", utilService.getDate()),
                        HttpStatus.BAD_REQUEST
                );
            }
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("400", "Operación no permitida (Rol)", utilService.getDate()),
                    HttpStatus.BAD_REQUEST
            );

        }

    }
    
    @PostMapping(value = "/transicionar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setTransicion(
            @RequestBody TransicionarRequest tran,
            @RequestHeader("Rol") String rol
    ) {
        String roles = hotelService.validar("TRANSICIONAR", rol);
        if (roles.equals("1")) {
            String flat = hotelService.transicionar(tran.getEstadoOrigen(), tran.getEstadoDestino(), tran.getIdHabitacion());
            if (!flat.equals("")) {
                return new ResponseEntity<>(
                        new ErrorResponse("0", "Transición exitosa!", utilService.getDate()),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        new ErrorResponse("400", "Error transición no permitida", utilService.getDate()),
                        HttpStatus.BAD_REQUEST
                );
            }
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("400", "Operación no permitida (Rol)", utilService.getDate()),
                    HttpStatus.BAD_REQUEST
            );

        }
    }
    
        
    @PostMapping(value = "/reservar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity reservar(
            @RequestBody ReservarRequest re,
            @RequestHeader("Rol") String rol
    ) {
        String roles = hotelService.validar("RESERVAR", rol);
        if (roles.equals("1")) {
            String flat = hotelService.reservar(re.getCantidadPersonas(), re.getIdHabitacion());
            if (!flat.equals("")) {
                return new ResponseEntity<>(
                        new ErrorResponse("0", "Reserva exitosa!", utilService.getDate()),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        new ErrorResponse("400", "Error cupo excedido", utilService.getDate()),
                        HttpStatus.BAD_REQUEST
                );
            }
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("400", "Operación no permitida (Rol)", utilService.getDate()),
                    HttpStatus.BAD_REQUEST
            );

        }
    }
 
    
    @GetMapping(value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consulta(          
            @RequestHeader("Rol") String rol,
            @RequestParam("id") String id
    ) {
        String roles = hotelService.validar("CONSULTAR", rol);
        if (roles.equals("1")) {
            HabitacionResponse habitaciones = hotelService.queryHabitacion(id).get(0);
            if (habitaciones != null) {
                return new ResponseEntity<HabitacionResponse>(
                        habitaciones,
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        new ErrorResponse("400", "Error en consulta", utilService.getDate()),
                        HttpStatus.BAD_REQUEST
                );
            }
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("400", "Operación no permitida (Rol)", utilService.getDate()),
                    HttpStatus.BAD_REQUEST
            );

        }

    }
     
    
    @DeleteMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity eliminar(          
            @RequestHeader("Rol") String rol,
            @RequestParam("id") String id
    ) {
        String roles = hotelService.validar("ELIMINAR", rol);
        if (roles.equals("1")) {
            HabitacionEntity habitaciones = hotelService.deleteHabitacion(id);
            if (habitaciones != null) {
                return new ResponseEntity<>(
                        new ErrorResponse("0", "Operación exitosa!", utilService.getDate()),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        new ErrorResponse("400", "Error no existe habitación", utilService.getDate()),
                        HttpStatus.BAD_REQUEST
                );
            }
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("400", "Operación no permitida (Rol)", utilService.getDate()),
                    HttpStatus.BAD_REQUEST
            );

        }

    }
     
    @PostMapping(value = "/crear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity crear(    
            @RequestBody HabitacionEntity habitacion,
            @RequestHeader("Rol") String rol
    ) {
        String roles = hotelService.validar("CREAR", rol);
        if (roles.equals("1")) {
            BigDecimal num = hotelService.saveHabitacion(habitacion);
            if (num.intValue() > 0) {
                return new ResponseEntity<>(
                        new ErrorResponse("0", "Operación exitosa!", utilService.getDate()),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        new ErrorResponse("400", "Error en registro de habitación", utilService.getDate()),
                        HttpStatus.BAD_REQUEST
                );
            }
        } else {
            return new ResponseEntity<>(
                    new ErrorResponse("400", "Operación no permitida (Rol)", utilService.getDate()),
                    HttpStatus.BAD_REQUEST
            );

        }

    }
     
  
  
}