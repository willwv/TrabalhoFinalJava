package com.javaee.willwv.TrabalhoFinalJava.controller.v1;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;
import com.javaee.willwv.TrabalhoFinalJava.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API do Cliente")
@RestController
@RequestMapping(ClienteController.BASE_URL)
public class ClienteController {
	public static final String BASE_URL = "/api/v1/cliente";
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@ApiOperation(value = "Lista de CLientes", notes = "Esse endpoint retorna uma lista com todos os CLientes")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Set<Cliente> obterTodosOsClientes(){
		return clienteService.ListarClientes();
	}
	
	@ApiOperation(value = "Criar cliente", notes = "Esse endpoint rcria um novo cliente.")
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Cliente criarCliente(@RequestBody Cliente cliente){
		return clienteService.CriarCliente(cliente);
	}
}
