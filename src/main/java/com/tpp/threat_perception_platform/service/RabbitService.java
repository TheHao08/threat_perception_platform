package com.tpp.threat_perception_platform.service;

import org.springframework.stereotype.Service;

@Service
public interface RabbitService {
    void createAgentQueue(String exchange, String queue, String
            routingKey);

    void sendMessage(String exchange, String routingKey, String message);
}
