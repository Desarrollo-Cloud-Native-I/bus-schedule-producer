package com.dcni.bus_schedule_producer.service;

import com.dcni.bus_schedule_producer.config.Constants;
import com.dcni.bus_schedule_producer.model.BusSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar el envío de horarios de autobuses a RabbitMQ.
 * Encapsula la lógica de negocio para publicar mensajes en el broker.
 *
 * @author GRUPO10
 * @version 1.0
 * @since 2026-02-11
 */
@Service
public class BusScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(BusScheduleService.class);

    private final RabbitTemplate rabbitTemplate;

    /**
     * Constructor del servicio.
     *
     * @param rabbitTemplate Template de RabbitMQ para enviar mensajes
     */
    public BusScheduleService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Envía un horario de autobús a RabbitMQ.
     * El mensaje es publicado en el exchange configurado con la routing key
     * definida.
     *
     * @param busSchedule Objeto con la información del horario a enviar
     */
    public void sendBusSchedule(BusSchedule busSchedule) {
        logger.info("Enviando mensaje a RabbitMQ: {}", busSchedule);
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_NAME, Constants.ROUTING_KEY, busSchedule);
        logger.info("Mensaje enviado exitosamente");
    }
}
