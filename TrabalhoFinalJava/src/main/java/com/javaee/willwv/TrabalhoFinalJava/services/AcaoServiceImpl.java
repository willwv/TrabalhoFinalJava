package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;

@Service
public class AcaoServiceImpl extends ServiceBase implements AcaoService {

	@Override
	public Acao ObterAcao(int id) {
		return new Acao() {};
	}

	@Override
	public Void CriarAcao(Acao acao) {
		return null;
		// Salvar acao no banco
	}

	@Override
	public List<Acao> ListarAcoes() {
		List<Acao> listaDeAcoes = null;
		// TODO Auto-generated method stub
		return listaDeAcoes;
	}

	@Override
	public Void AtualizarAcao(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void DeletarAcao(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void VenderAcao(int idAcao, int idCliente, double valor) {
		// TODO Auto-generated method stub
		return null;
	}

}
