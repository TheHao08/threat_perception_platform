package com.tpp.threat_perception_platform.service.impl;
import com.tpp.threat_perception_platform.service.RabbitService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            channel.queueBind(queue, exchange, routingKey);
            return null;
        });
    }
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
    }
}
