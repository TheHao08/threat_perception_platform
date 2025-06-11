package com.tpp.threat_perception_platform.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.tpp.threat_perception_platform.pojo.*;
import com.tpp.threat_perception_platform.service.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class RabbitSysInfoConsumer {

    @Autowired
    private HostService hostService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private AppService appService;

    @RabbitListener(queues = "sysinfo_queue")

    public void receive(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);
        //将数据存储到数据库
        try {
            Host host = JSON.parseObject(message, Host.class);
            // 存储到数据库
            int res = hostService.saveHost(host);

            if (res > 0){
                // 手动 ACK, 先获取 deliveryTag
                Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
                // ACK
                channel.basicAck(deliveryTag,false);
            }
        } catch (Exception e) {
            //throw new RuntimeException(e);
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
        }
    }

    @RabbitListener(queues ="status_queue")
    public void receiveStatus(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);
        Host host = JSON.parseObject(message, Host.class);
        //将数据存储到数据库
        try {
            //反序列化数据
            //根据macAddress查询主机信息

            // 存储到数据库
            int res = hostService.updateHostByMacAddress(host);

            if (res > 0){
                // 手动 ACK, 先获取 deliveryTag
                Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
                // ACK
                channel.basicAck(deliveryTag,false);
            }
        } catch (Exception e) {
            //throw new RuntimeException(e);
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
        }
    }

    @RabbitListener(queues = "account_queue")
    public void receiveAccount(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);

        try {
            List<Account> accounts = JSON.parseArray(message, Account.class);
            // 存储到数据库
            int successCount = 0;
            for (Account account : accounts) {

                int res = accountService.save(account);
                if (res > 0) {
                    successCount++;
                }
//                System.out.println("===================================");
//                System.out.println(account);
//                System.out.println("===================================");
            }
            // 全部处理完毕后ACK
            System.out.println("成功保存账号数量: " + successCount);
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.err.println("处理账号信息时发生错误: " + e.getMessage());
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
        }
    }

    @RabbitListener(queues = "service_queue")
    public void receiveService(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);
        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            int service_count = 0;
            List<Services> servicesList = JSON.parseArray(message, Services.class);
            for (Services services : servicesList) {
                service_count++;
                servicesService.saveServices(services);
            }
            System.out.println("成功保存服务数量: " + service_count);
            // ✅ 成功后 ACK
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            System.err.println("处理失败: " + e.getMessage());
            // ❌ 不应该 ACK 错误消息，否则 RabbitMQ 会误以为处理成功
            // 你可以选择重试（requeue = true）或丢弃
            channel.basicNack(deliveryTag, false, false); // false 表示不重回队列
        }
    }


    @RabbitListener(queues = "process_queue")
    public void receiveProcess(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);
        //将数据存储到数据库
        try {
            List<Processes> processesList = JSON.parseArray(message, Processes.class);
            int process_count = 0;
            for (Processes process : processesList) {
                process_count++;
                processService.save(process);
            }
            System.out.println("成功保存进程数量: " + process_count);
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
        }
    }

    @RabbitListener(queues="app_queue")
    public void receiveApp(String message, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        System.out.println("Received message: " + message);
        //将数据存储到数据库
        try {
            List<App> appList = JSON.parseArray(message, App.class);
            int app_count = 0;
            for (App app : appList) {
                app_count++;
                // 调用服务保存应用信息
                appService.save(app);
            }
            System.out.println("成功保存应用数量: " + app_count);
            // 手动 ACK, 先获取 deliveryTag
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            // ACK
            channel.basicAck(deliveryTag,false);
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常堆栈
            Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(deliveryTag,false);
        }
    }

}
