package com.javaee.willwv.TrabalhoFinalJava.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@Configuration
public class RabbitMQConfigVenderAcao extends RabbitMQConfigBase{

	public static final String QUEUE_VENDER_ACAO_MESSAGES = "messages-vender-acao-queue";
    public static final String EXCHANGE_VENDER_ACAO_MESSAGES = "messages-vender-acao-exchange";
    public static final String QUEUE_DEAD_ACAO_MESSAGES = "dead-messages-acao-queue";
 
    @Bean
    Queue messagesAcaoQueue() {
    	return QueueBuilder.durable(QUEUE_VENDER_ACAO_MESSAGES)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", QUEUE_DEAD_ACAO_MESSAGES)
                .withArgument("x-message-ttl", 15000) //if message is not consumed in 15 seconds send to DLQ
                .build();
    }
 
    @Bean
    Queue deadMessagesAcaoQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_ACAO_MESSAGES).build();
    }
 
    @Bean
    Exchange messagesAcaoExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_VENDER_ACAO_MESSAGES).build();
    }
 
    @Bean
    Binding bindingAcao(Queue messagesQueue, TopicExchange messagesExchange) {
        return BindingBuilder.bind(messagesQueue).to(messagesExchange).with(QUEUE_VENDER_ACAO_MESSAGES);
    }   
    
}
