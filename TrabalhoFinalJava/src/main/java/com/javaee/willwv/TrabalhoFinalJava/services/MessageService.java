package com.javaee.willwv.TrabalhoFinalJava.services;

import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;
import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;
import com.javaee.willwv.TrabalhoFinalJava.domain.Empresa;
import com.javaee.willwv.TrabalhoFinalJava.domain.RMQMessage;

public interface MessageService {
	void sendMessage(RMQMessage message);
	void sendMessage(Acao acao);
	void sendMessage(Cliente cliente);
	void sendMessage(Empresa empresa);
}
