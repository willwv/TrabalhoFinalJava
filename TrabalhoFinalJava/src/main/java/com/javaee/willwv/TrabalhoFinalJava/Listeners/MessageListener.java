package com.javaee.willwv.TrabalhoFinalJava.Listeners;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javaee.willwv.TrabalhoFinalJava.config.EmailConfig;
import com.javaee.willwv.TrabalhoFinalJava.config.RabbitMQConfig;
import com.javaee.willwv.TrabalhoFinalJava.config.RabbitMQConfigVenderAcao;
import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;
import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;
import com.javaee.willwv.TrabalhoFinalJava.domain.Empresa;
import com.javaee.willwv.TrabalhoFinalJava.domain.RMQMessage;
import com.javaee.willwv.TrabalhoFinalJava.services.AcaoService;
import com.javaee.willwv.TrabalhoFinalJava.services.ClienteService;
import com.javaee.willwv.TrabalhoFinalJava.services.EmpresaService;

@Component
public class MessageListener {
	static final Logger logger = LoggerFactory.getLogger(MessageListener.class);
	private final AcaoService acaoService;
	private final EmpresaService empresaService;
	private final ClienteService clienteService;
	
	public MessageListener(AcaoService acaoService, EmpresaService empresaService, ClienteService clienteService) {
		this.acaoService = acaoService;
		this.empresaService = empresaService;
		this.clienteService = clienteService;
	}
	
	@RabbitListener(queues = RabbitMQConfig.QUEUE_MESSAGES)
	public void processMessage(RMQMessage message) {
        logger.info("Message Received");
        logger.info("Sebject:" + message.subject);
        logger.info("Body:" + message.body);
	}
	
	@RabbitListener(queues = RabbitMQConfigVenderAcao.QUEUE_VENDER_ACAO_MESSAGES)
	public void processMessage(Acao acao) {
		
		acaoService.AtualizarAcao(acao);
		EnviarEmail(acao);
		
        logger.info("Acao Received");
        logger.info("Id:" + acao.Id);
        logger.info("IdComprador:" + acao.IdComprador);
        logger.info("IdEmpresa:" + acao.IdEmpresa);
        /*logger.info("Valor:" + acao.val);*/
	}
	
	private void EnviarEmail(Acao acao) {		
		
		Cliente clienteSelecionado = ObterCliente(acao.IdComprador);
		Empresa empresaSelecionada = ObterEmpresa(acao.IdEmpresa);
		
		
		String fromEmail = "vendasacoesjava@gmail.com";
		String password = "401121514";
		String toEmail = empresaSelecionada.Email + "," + clienteSelecionado.Email;
		String emailBody = "A ação de id " + acao.Id + " pertencente a empresa " + empresaSelecionada.Nome + " foi vendida para " + clienteSelecionado.Nome ;
		
		System.out.println("Initializing email send");
		
		EmailConfig config = new EmailConfig();
		
		config.sendEmail(fromEmail, password, toEmail, "Venda de ação efetuada.", emailBody);
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
}
