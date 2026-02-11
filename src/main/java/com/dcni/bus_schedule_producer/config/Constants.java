package com.dcni.bus_schedule_producer.config;

/**
 * Clase de constantes para la configuración de RabbitMQ.
 * Centraliza los nombres de colas, exchanges y routing keys.
 *
 * @author GRUPO10
 * @version 1.0
 * @since 2026-02-11
 */
public class Constants {

    /**
     * Nombre de la cola de RabbitMQ.
     */
    public static final String QUEUE_NAME = "bus-schedule-queue";

    /**
     * Nombre del exchange de RabbitMQ.
     */
    public static final String EXCHANGE_NAME = "bus-schedule-exchange";

    /**
     * Routing key para enrutar mensajes.
     */
    public static final String ROUTING_KEY = "bus-schedule-key";

    /**
     * Constructor privado para prevenir instanciación.
     */
    private Constants() {
        // No se permite instanciar esta clase
    }
}