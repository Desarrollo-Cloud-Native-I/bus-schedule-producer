package com.dcni.bus_schedule_producer.controller;

import com.dcni.bus_schedule_producer.model.BusSchedule;
import com.dcni.bus_schedule_producer.service.BusScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar los horarios de autobuses.
 * Proporciona endpoints para enviar información de horarios a RabbitMQ.
 *
 * @author GRUPO10
 * @version 1.0
 * @since 2026-02-11
 */
@RestController
@RequestMapping("/api/bus-schedule")
public class BusScheduleController {

    private final BusScheduleService busScheduleService;

    /**
     * Constructor del controlador.
     *
     * @param busScheduleService Servicio para gestionar los horarios de autobuses
     */
    public BusScheduleController(BusScheduleService busScheduleService) {
        this.busScheduleService = busScheduleService;
    }

    /**
     * Endpoint para enviar un horario de autobús a RabbitMQ.
     *
     * @param busSchedule Objeto con la información del horario del autobús
     * @return ResponseEntity con mensaje de éxito o error
     */
    @PostMapping
    public ResponseEntity<String> sendBusSchedule(@RequestBody BusSchedule busSchedule) {
        try {
            busScheduleService.sendBusSchedule(busSchedule);
            return ResponseEntity.ok("Mensaje enviado a RabbitMQ exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar mensaje: " + e.getMessage());
        }
    }
}