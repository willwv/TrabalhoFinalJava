package com.javaee.willwv.TrabalhoFinalJava.domain;
import org.springframework.data.annotation.Id;

public class Cliente {
	@Id
	public String Id;
	public String Nome;
	public String Email;
}
