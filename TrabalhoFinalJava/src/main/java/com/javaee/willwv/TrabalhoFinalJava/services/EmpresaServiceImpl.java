package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.willwv.TrabalhoFinalJava.domain.Empresa;
import com.javaee.willwv.TrabalhoFinalJava.repositories.AcaoRepository;
import com.javaee.willwv.TrabalhoFinalJava.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl extends ServiceBase implements EmpresaService{

	private EmpresaRepository empresaRepository;
	
	public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Empresa CriarEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public Set<Empresa> ListarEmpresas() {
		Set<Empresa> listaEmpresas = new HashSet<>();
		empresaRepository.findAll().iterator().forEachRemaining(listaEmpresas::add);
		return listaEmpresas;
	}

}
