package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;
import java.util.Set;

import com.javaee.willwv.TrabalhoFinalJava.domain.Empresa;

public interface EmpresaService {	
	Empresa CriarEmpresa(Empresa empresa);
	Set<Empresa> ListarEmpresas();
}
