package com.dcni.bus_schedule_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del microservicio productor de horarios de autobuses.
 * Este microservicio publica mensajes de horarios a RabbitMQ para ser
 * consumidos
 * por otros servicios.
 *
 * @author GRUPO10
 * @version 1.0
 * @since 2026-02-11
 */
@SpringBootApplication
public class BusScheduleProducerApplication {

	/**
	 * Método principal que inicia la aplicación Spring Boot.
	 *
	 * @param args Argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(BusScheduleProducerApplication.class, args);
	}

}
