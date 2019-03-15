package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;

import com.javaee.willwv.TrabalhoFinalJava.domain.Empresa;

public interface EmpresaService {
	Empresa ObterEmpresa(int id);	
	Void CriarEmpresa(Empresa empresa);
	List<Empresa> ListarEmpresas();
	Void AtualizarEmpresa(String nome);
	Void Empresa(int id);
}
