package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;
import java.util.Set;

import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;

public interface AcaoService {
	Acao ObterAcao(String id);	
	Acao CriarAcao(Acao acao);
	Set<Acao> ListarAcoes();
	Acao AtualizarAcao(Acao acao);
	void DeletarAcao(int id);
	void VenderAcao(int idAcao, int idCliente, double valor);
}
