package com.jdp.rabbitmq.consumer;

/**
 * @ClassName FanoutReceiverB
 * @Description TODO
 * @Author jdp
 * @Date 15:02 2023/2/17
 * @Version 1.0
 **/
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverB消费者收到消息  : " +testMessage.toString());
    }
}
