package com.tpp.threat_perception_platform.config;
<<<<<<< HEAD
=======

>>>>>>> main
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
<<<<<<< HEAD
public class RabbitMqConfig {
=======
public class RabbitMQConfig {
>>>>>>> main
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        return new RabbitTemplate(factory);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> main
