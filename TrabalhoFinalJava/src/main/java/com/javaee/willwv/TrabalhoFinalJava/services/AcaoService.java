package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;

import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;

public interface AcaoService {
	Acao ObterAcao(int id);	
	Void CriarAcao(Acao acao);
	List<Acao> ListarAcoes();
	Void AtualizarAcao(String nome);
	Void DeletarAcao(int id);
	Void VenderAcao(int idAcao, int idCliente, double valor);
}
