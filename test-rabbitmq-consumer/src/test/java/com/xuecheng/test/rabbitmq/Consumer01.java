package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Consumer01 {
    //队列
    private static final String QUEUE = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //通过连接工厂创建新的连接和mq建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);//端口
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //设置虚拟机,一个mq服务可以设置多个虚拟机，每个虚拟机就相当于一个独立的mq
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        //建立新连接
        connection = connectionFactory.newConnection();
        //创建会话通道，生产者和mq服务所有的通信都在channel中完成
        Channel channel = connection.createChannel();

        //实现消费方法
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            //当接收到消息后，此方法将被调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body, "utf-8"));
            }
        };

        channel.queueDeclare(QUEUE, true, false, false, null);
        //监听队列
        channel.basicConsume(QUEUE, true, defaultConsumer);
    }
}
