package com.javaee.willwv.TrabalhoFinalJava.Listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javaee.willwv.TrabalhoFinalJava.config.RabbitMQConfig;
import com.javaee.willwv.TrabalhoFinalJava.config.RabbitMQConfigAcao;
import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;
import com.javaee.willwv.TrabalhoFinalJava.domain.RMQMessage;

@Component
public class MessageListener {
	static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

	@RabbitListener(queues = RabbitMQConfig.QUEUE_MESSAGES)
	public void processMessage(RMQMessage message) {
        logger.info("Message Received");
        logger.info("Sebject:" + message.subject);
        logger.info("Body:" + message.body);
	}
	
	@RabbitListener(queues = RabbitMQConfigAcao.QUEUE_ACAO_MESSAGES)
	public void processMessage(Acao acao) {
        logger.info("Acao Received");
        logger.info("Id:" + acao.Id);
        logger.info("IdComprador:" + acao.IdComprador);
        logger.info("IdEmpresa:" + acao.IdEmpresa);
        logger.info("Valor:" + acao.Valor);
	}
}
