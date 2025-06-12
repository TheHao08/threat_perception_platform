package com.tpp.threat_perception_platform.service.impl;
<<<<<<< HEAD
=======

>>>>>>> main
import com.tpp.threat_perception_platform.service.RabbitService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
@Service
public class RabbitServiceImpl implements RabbitService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 创建队列
     *
     * @param exchange ： 交换机名字
     * @param queue : 队列名字
     * @param routingKey ：路由键
     */
    @Override
    public void createAgentQueue(String exchange, String queue, String
            routingKey) {
// 创建并绑定队列
        rabbitTemplate.execute(channel -> {
// 创建队列
            channel.queueDeclare(queue, true, false, false, null);
// 绑定交换机
=======

@Service
public class RabbitServiceImpl implements RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 创建队列方法
     *
     * @param exchange   交换机名称
     * @param queue
     * @param routingKey 路由键
     */
    @Override
    public void createAgentQueue(String exchange, String queue, String routingKey) {
        // 创建并绑定队列
        rabbitTemplate.execute(channel -> {
            // 创建队列
            channel.queueDeclare(queue, true, false, false, null);
            // 绑定交换机
>>>>>>> main
            channel.queueBind(queue, exchange, routingKey);
            return null;
        });
    }
<<<<<<< HEAD
    /**
     * 发送消息到rabbitMQ
     * @param exchange : 交换机
     * @param routingKey : 路由键
     * @param message : 发送的消息
     */
    @Override
    public void sendMessage(String exchange, String routingKey, String message)
    {
        // 发送消息到队列
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
=======

    /**
     * 发送消息到指定的交换机和路由键
     *
     * @param exchange
     * @param routingKey
     * @param message
     */
    @Override
    public void sendMessage(String exchange, String routingKey, String message) {
        // 发送消息到队列
        rabbitTemplate.convertAndSend(exchange, routingKey, message);

>>>>>>> main
    }
}
