package com.tpp.threat_perception_platform.service;

public interface RabbitService {
    public void createAgentQueue(String exchange, String queue, String routingKey);

    public void sendMessage(String exchange, String routingKey, String message);
}
