package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.willwv.TrabalhoFinalJava.Listeners.MessageListener;
import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;
import com.javaee.willwv.TrabalhoFinalJava.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl  extends ServiceBase implements ClienteService{
	static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Cliente CriarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Set<Cliente> ListarClientes() {
		Set<Cliente> listaClientes = new HashSet<>();
		clienteRepository.findAll().iterator().forEachRemaining(listaClientes::add);
		return listaClientes;
	}

}
