package com.dcni.bus_schedule_producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Representa la información de un horario de autobús.
 * Esta clase encapsula los datos relacionados con un bus específico,
 * incluyendo su identificador, ruta y ubicaciones de origen y destino.
 *
 * @author GRUPO10
 * @version 1.0
 * @since 2026-02-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusSchedule {

    /**
     * Identificador único del autobús.
     */
    private Long idBus;

    /**
     * Nombre o código de la ruta del autobús.
     */
    private String route;

    /**
     * Ubicación de origen del recorrido.
     */
    private String origin;

    /**
     * Ubicación de destino del recorrido.
     */
    private String destination;

    /**
     * Fecha y hora del registro del horario.
     */
    private LocalDateTime timestamp;
}