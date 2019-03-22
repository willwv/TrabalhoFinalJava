package com.javaee.willwv.TrabalhoFinalJava.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

public class RabbitMQConfigBase implements RabbitListenerConfigurer{
	    
	    @Bean
	    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
	        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
	        return rabbitTemplate;
	    }
	 
	    @Bean
	    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }
	    
	    @Override
	    public void configureRabbitListeners(RabbitListenerEndpointRegistrar register) {
	        register.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	    }
	 
	    @Bean
	    MessageHandlerMethodFactory messageHandlerMethodFactory() {
	        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
	        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
	        return messageHandlerMethodFactory;
	    }
	 
	    @Bean
	    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
	        return new MappingJackson2MessageConverter();
	    }
}
