package com.tpp.threat_perception_platform.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//*这是一个RabbitMQ配置类，用于配置RabbitTemplate Bean。

@Configuration
public class RabbitMqConfig {

    @Bean//bean的作用是将一个对象注册到Spring容器中，方便其他组件进行依赖注入
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        return new RabbitTemplate(factory);
    }
}