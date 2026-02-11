package com.dcni.bus_schedule_producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de RabbitMQ para el microservicio productor.
 * Define la cola, el exchange, el binding y los convertidores de mensajes.
 *
 * @author GRUPO10
 * @version 1.0
 * @since 2026-02-11
 */
@Configuration
public class RabbitMQConfig {

    /**
     * Define la cola de RabbitMQ para recibir mensajes de horarios de autobuses.
     *
     * @return Cola durable configurada
     */
    @Bean
    public Queue queue() {
        return new Queue(Constants.QUEUE_NAME, true);
    }

    /**
     * Define el exchange de tipo Direct para enrutar mensajes.
     *
     * @return DirectExchange configurado
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(Constants.EXCHANGE_NAME);
    }

    /**
     * Vincula la cola con el exchange usando una routing key.
     *
     * @param queue    Cola a vincular
     * @param exchange Exchange a vincular
     * @return Binding configurado
     */
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(Constants.ROUTING_KEY);
    }

    /**
     * Configura el convertidor de mensajes para serializar objetos a JSON.
     *
     * @return MessageConverter configurado con Jackson
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Configura el template de RabbitMQ con el convertidor de mensajes.
     *
     * @param connectionFactory Fábrica de conexiones de RabbitMQ
     * @return RabbitTemplate configurado
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}