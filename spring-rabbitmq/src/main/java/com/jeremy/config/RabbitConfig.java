package com.jeremy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * @author: laizc
 * @date: created in 2022/5/10
 * @desc: 配置 rabbitTemplate
 **/
@Configuration
@Slf4j
public class RabbitConfig {


    @Autowired(required = false)
    private ConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("【correlationData】:" + correlationData);
                log.info("【ack】" + ack);
                log.info("【cause】" + cause);
                if (ack) {
                    log.info("【发送成功】");
                } else {
                    log.info("【发送失败】");
                }
            }
        });
	    rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnsCallback(returnedMessage->{
            System.out.println("return执行了...");
            String exchange = returnedMessage.getExchange();
            String routingKey = returnedMessage.getRoutingKey();
            //String queue = returnedMessage.getMessage().getMessageProperties().getConsumerQueue();
            System.out.println("消息从" + exchange + "到路由key为" + routingKey);
            System.out.println("消息为：" + new String(returnedMessage.getMessage().getBody(), StandardCharsets.UTF_8));
        });
        return rabbitTemplate;
    }

    @Bean
    public DirectExchange myExchange() {
        DirectExchange directExchange = new DirectExchange("myExchange");
        return directExchange;
    }

    @Bean
    public Queue myQueue() {
        Queue queue = new Queue("myQueue",true);
        return queue;
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(myQueue()).to(myExchange()).with("myRoutingKey");
    }

}
