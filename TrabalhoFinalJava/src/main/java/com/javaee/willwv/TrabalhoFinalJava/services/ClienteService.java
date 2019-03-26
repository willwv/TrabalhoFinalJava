package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;
import java.util.Set;

import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;

public interface ClienteService {
	Cliente ObterCliente(String id);	
	Cliente CriarCliente(Cliente cliente);
	Set<Cliente> ListarClientes();
	Void AtualizarCliente(String nome);
	Void DeletarCliente(int id);
	Void ComprarAcao(int idAcao, int idCliente, double valor);
}
