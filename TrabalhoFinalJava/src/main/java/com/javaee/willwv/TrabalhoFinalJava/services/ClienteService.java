package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;
import java.util.Set;

import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;

public interface ClienteService {
	Cliente CriarCliente(Cliente cliente);
	Set<Cliente> ListarClientes();
}
