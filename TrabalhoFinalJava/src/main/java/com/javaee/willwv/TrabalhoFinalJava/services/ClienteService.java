package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;

import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;

public interface ClienteService {
	Cliente ObterCliente(int id);	
	Cliente CriarCliente(Cliente cliente);
	List<Cliente> ListarClientes();
	Void AtualizarCliente(String nome);
	Void DeletarCliente(int id);
}
