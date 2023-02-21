package com.jdp.rabbitmq.config;

/**
 * @ClassName RabbitConfig
 * @Description TODO
 * @Author jdp
 * @Date 15:15 2023/2/17
 * @Version 1.0
 **/
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("ConfirmCallback:     "+"相关数据："+correlationData);
            System.out.println("ConfirmCallback:     "+"确认情况："+ack);
            System.out.println("ConfirmCallback:     "+"原因："+cause);
        });

        rabbitTemplate.setReturnsCallback(returnCallback ->{
            System.out.println("ReturnCallback:     "+"消息："+returnCallback.getMessage());
            System.out.println("ReturnCallback:     "+"回应码："+returnCallback.getReplyCode());
            System.out.println("ReturnCallback:     "+"回应信息："+returnCallback.getReplyText());
            System.out.println("ReturnCallback:     "+"交换机："+returnCallback.getExchange());
            System.out.println("ReturnCallback:     "+"路由键："+returnCallback.getRoutingKey());

        });
        return rabbitTemplate;
    }
}

