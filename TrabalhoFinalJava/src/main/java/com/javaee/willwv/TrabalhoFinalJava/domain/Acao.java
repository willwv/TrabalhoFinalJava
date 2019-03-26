package com.javaee.willwv.TrabalhoFinalJava.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao {
	@org.springframework.data.annotation.Id
	public String Id;
	public String IdComprador;
	public String IdEmpresa;
	public double ValorInicial;
	public double ValorAtual;
	public Date DataUltimaVenda;
}
