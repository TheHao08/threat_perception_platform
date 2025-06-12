package com.tpp.threat_perception_platform.service;

public interface RabbitService {
<<<<<<< HEAD
    public void createAgentQueue(String exchange, String queue, String routingKey);

    public void sendMessage(String exchange, String routingKey, String message);
}
=======

    /**
     * 创建队列方法
     * @param exchange 交换机名称
     * @param queue
     * @param routingKey 路由键
     */
    public void createAgentQueue(String exchange,String queue,String routingKey);
    // 创建队列a

    /**
     * 发送消息到指定的交换机和路由键
     * @param exchange
     * @param routingKey
     * @param message
     */
    public void sendMessage(String exchange, String routingKey, String message);


}
>>>>>>> main
