package com.jdp.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author jdp
 * @Date 10:53 2023/2/17
 * @Version 1.0
 **/


@Component
//监听的队列名称 TestDirectQueue
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("第一个：DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}
