package com.javaee.willwv.TrabalhoFinalJava.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.javaee.willwv.TrabalhoFinalJava.config.RabbitMQConfig;
import com.javaee.willwv.TrabalhoFinalJava.config.RabbitMQConfigVenderAcao;
import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;
import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;
import com.javaee.willwv.TrabalhoFinalJava.domain.Empresa;
import com.javaee.willwv.TrabalhoFinalJava.domain.RMQMessage;

@Service
public class MessageServiceImpl implements MessageService{
	private final RabbitTemplate rabbitTemplate;
	 
    public MessageServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    @Override
    public void sendMessage(RMQMessage message) {
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_MESSAGES, message);
    }

	@Override
	public void sendMessage(Acao acao) {
		this.rabbitTemplate.convertAndSend(RabbitMQConfigVenderAcao.QUEUE_VENDER_ACAO_MESSAGES, acao);		
	}
}
