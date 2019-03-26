package com.javaee.willwv.TrabalhoFinalJava.controller.v1;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;
import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;
import com.javaee.willwv.TrabalhoFinalJava.domain.Empresa;
import com.javaee.willwv.TrabalhoFinalJava.services.AcaoService;
import com.javaee.willwv.TrabalhoFinalJava.services.ClienteService;
import com.javaee.willwv.TrabalhoFinalJava.services.EmpresaService;
import com.javaee.willwv.TrabalhoFinalJava.services.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("This id Acao API")
@RestController
@RequestMapping(AcaoController.BASE_URL)
public class AcaoController {
	public static final String BASE_URL = "/api/v1/acoes";
	
	private final AcaoService acaoService;
	private final MessageService messageService;
	private final ClienteService clienteService;
	private final EmpresaService empresaService;
	
	public AcaoController(AcaoService acaoService, MessageService messageService, ClienteService clienteService, EmpresaService empresaService) {
		this.acaoService = acaoService;
		this.messageService = messageService;
		this.clienteService = clienteService;
		this.empresaService = empresaService;
	}
	
	@ApiOperation(value = "Cadastrar acao", notes = "Esse endpoint cria uma nova acao.")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void SalvarAcao(@RequestBody Acao acao) {
		ValidarCriacaoAcao(acao);
		acaoService.CriarAcao(acao);
	}
	
	private void ValidarCriacaoAcao(Acao acao) {
		if(StringUtils.isEmpty(ObterEmpresa(acao.IdEmpresa).Id))
		{
			throw new IllegalArgumentException("Empresa não encontrada. ID: " + acao.IdEmpresa.toString() );
		}
		if(!StringUtils.isEmpty(ObterAcao(acao.Id).Id)) 
		{
			throw new IllegalArgumentException("Acao já existe. ID: " + acao.Id.toString() );
		}
	}
	
	@ApiOperation(value = "Obter acoes", notes = "Esse endpoint retorna todas as acoes já cadastradas.")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Set<Acao> ObterAcoes() {
		return acaoService.ListarAcoes();
	}
	
	@ApiOperation(value = "Vender acao", notes = "Esse endpoint vende uma acao.")
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public String VenderAcao(@RequestBody Acao acao) {
		ValidarAcao(acao);
		messageService.sendMessage(acao);
		return "Ação encaminhada para venda.";
	}
	
	private void ValidarAcao(Acao acao) {
		if(StringUtils.isEmpty(ObterEmpresa(acao.IdEmpresa).Id))
		{
			throw new IllegalArgumentException("Empresa Not Found For ID value: " + acao.IdEmpresa.toString() );
		}
		if(StringUtils.isEmpty(ObterCliente(acao.IdComprador).Id)) 
		{
			throw new IllegalArgumentException("Cliente Not Found For ID value: " + acao.IdComprador.toString() );
		}
		if(StringUtils.isEmpty(ObterAcao(acao.Id).Id)) 
		{
			throw new IllegalArgumentException("Acao Not Found For ID value: " + acao.Id.toString() );
		}
	}
	
	private Empresa ObterEmpresa(String idEmpresa) {
		Set<Empresa> empresas = empresaService.ListarEmpresas();
		Empresa empresaSelecionada = new Empresa();
		
		for(Empresa empresa: empresas) {
			if(empresa.Id.equals(idEmpresa)) {
				empresaSelecionada.Id = empresa.Id;
				empresaSelecionada.Nome = empresa.Nome;
				empresaSelecionada.Email = empresa.Email;
			}
		}
		
		return empresaSelecionada;
	}
	
	private Cliente ObterCliente(String idCliente) {
		Set<Cliente> clientes = clienteService.ListarClientes();
		Cliente clienteSelecionado = new Cliente();
		
		for(Cliente cliente: clientes) {
			if(cliente.Id.equals(idCliente)) {  
				clienteSelecionado.Id = cliente.Id;
				clienteSelecionado.Nome = cliente.Nome;
				clienteSelecionado.Email = cliente.Email;
			}
		}
		
		return clienteSelecionado;
	}
	
	private Acao ObterAcao(String idAcao) {
		Set<Acao> acoes = acaoService.ListarAcoes();
		Acao acaoSelecionada = new Acao();
		
		for(Acao acao: acoes) {
			if(acao.Id.equals(idAcao)) {  
				acaoSelecionada.Id = acao.Id;
				acaoSelecionada.IdComprador = acao.IdComprador;
				acaoSelecionada.IdEmpresa = acao.IdEmpresa;
				acaoSelecionada.ValorAtual = acao.ValorAtual;
				acaoSelecionada.ValorInicial = acao.ValorInicial;
			}
		}
		
		return acaoSelecionada;
	}
	
}
