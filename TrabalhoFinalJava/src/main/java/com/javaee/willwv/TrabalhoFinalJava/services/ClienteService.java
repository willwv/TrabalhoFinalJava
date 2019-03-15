package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;

import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;

public interface ClienteService {
	Cliente ObterCliente(int id);	
	Void CriarCliente(Cliente cliente);
	List<Cliente> ListarClientes();
	Void AtualizarCliente(String nome);
	Void DeletarCliente(int id);
	Void ComprarAcao(int idAcao, int idCliente, double valor);
}
