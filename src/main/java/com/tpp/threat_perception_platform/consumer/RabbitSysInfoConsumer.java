package com.tpp.threat_perception_platform.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.service.HostService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Map;
//@Component
//public class RabbitSysInfoConsumer {
//
//
//    @Autowired
//    private HostService hostService;
//
//    @RabbitListener(queues = "sysinfo_queue")
//    public void receive(String message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
//        System.out.println("Received message: " + message);
//
//
//            // 将数据存储到数据库
//            Host host = JSON.parseObject(message, Host.class);
//
//            // 存储到数据库
//            int res = hostService.saveHost(host);
//            if (res > 0) {
//                // 手动 ACK, 先获取 deliveryTag
//                Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//                // ACK
//                channel.basicAck(deliveryTag, false);
//            }
//
//            // 手动 ACK, 先获取 deliveryTag
//            Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//            // ACK
//            channel.basicAck(deliveryTag, false);
//
//
//    }

@Component
public class RabbitSysInfoConsumer {
    @Autowired
    private HostService hostService;
    @RabbitListener(queues = "sysinfo_queue")
    public void receive(String message, @Headers Map<String,Object> headers,
                        Channel channel) throws IOException {
        try {
            System.out.println("Received message: " + message);
            // 将数据存储到数据库
            Host host = JSON.parseObject(message, Host.class);
            // 存储到数据库
            int res = hostService.saveHost(host);
            if (res > 0){
            // 手动 ACK, 先获取 deliveryTag
                Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
                channel.basicAck(deliveryTag,false);
            }
        } catch (IOException e) {
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
            //throw new RuntimeException(e);
        }
    }

    @RabbitListener(queues = "status_queue")
    public void receiveStatus(String message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);

        try {
            // 将数据存储到数据库
            Host host = JSON.parseObject(message, Host.class);

            // 更新数据库
            int res = hostService.updateHost(host);

            if (res > 0) {
                // 手动 ACK, 先获取 deliveryTag
                Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
                // ACK
                channel.basicAck(deliveryTag, false);
            }
        } catch (IOException e) {
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag, false);
            // throw new RuntimeException(e);
        }
    }
}



