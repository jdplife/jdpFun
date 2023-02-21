package com.jdp.rabbitmq.consumer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @ClassName FanoutReceiverA
 * @Description TODO
 * @Author jdp
 * @Date 15:01 2023/2/17
 * @Version 1.0
 **/


@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverA消费者收到消息  : " +testMessage.toString());
    }
}
