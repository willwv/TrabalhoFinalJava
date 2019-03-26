package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;
import com.javaee.willwv.TrabalhoFinalJava.repositories.AcaoRepository;

@Service
public class AcaoServiceImpl extends ServiceBase implements AcaoService {
	
	private AcaoRepository acaoRepository;
	
	public AcaoServiceImpl(AcaoRepository acaoRepository) {
		this.acaoRepository = acaoRepository;
	}
	
	@Override
	public Acao ObterAcao(String id) {
		return new Acao() {};
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao CriarAcao(Acao acao) {
		return acaoRepository.save(acao);
	}

	@Override
	public Set<Acao> ListarAcoes() {
		Set<Acao> listaDeAcoes = new HashSet<>();
		this.acaoRepository.findAll().iterator().forEachRemaining(listaDeAcoes::add);
		// TODO Auto-generated method stub
		return listaDeAcoes;
	}

	@Override
	public Acao AtualizarAcao(Acao acao) {
		acao.DataUltimaVenda = new Date();
		return CriarAcao(acao);
	}

	@Override
	public void DeletarAcao(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VenderAcao(int idAcao, int idCliente, double valor) {
		// TODO Auto-generated method stub
		;
	}

}
