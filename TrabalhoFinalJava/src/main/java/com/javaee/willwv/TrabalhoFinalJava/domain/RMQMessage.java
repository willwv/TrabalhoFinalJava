package com.javaee.willwv.TrabalhoFinalJava.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RMQMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String subject;
	public String body;
}
