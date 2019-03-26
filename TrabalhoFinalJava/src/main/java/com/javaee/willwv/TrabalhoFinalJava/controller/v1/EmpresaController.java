package com.javaee.willwv.TrabalhoFinalJava.controller.v1;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.willwv.TrabalhoFinalJava.domain.Empresa;
import com.javaee.willwv.TrabalhoFinalJava.services.EmpresaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API do Cliente")
@RestController
@RequestMapping(EmpresaController.BASE_URL)
public class EmpresaController {
	public static final String BASE_URL = "/api/v1/empresas";
	
	private final EmpresaService empresaService;
	
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
	@ApiOperation(value = "Lista de Empresas", notes = "Esse endpoint retorna uma lista com todas as Empresas.")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Set<Empresa> ObterEmpresas(){
		return empresaService.ListarEmpresas();
	}
	
	@ApiOperation(value = "Criar Empresa", notes = "Esse endpoint cria uma nova Empresa.")
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Empresa CriarEmpresa(@RequestBody Empresa empresa) {
		return empresaService.CriarEmpresa(empresa);
	}

}
