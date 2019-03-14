package com.javaee.willwv.TrabalhoFinalJava.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {}
	public ResourceNotFoundException(String message) {
		super(message);
	}
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}
	public ResourceNotFoundException(String message,
			Throwable cause, boolean enableSuppresion,
			boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);
	}
}
