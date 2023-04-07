package br.com.patio.projeto.exceptionhandlers.exceptions;

public class NotFoundElementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundElementException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundElementException(String message) {
		super(message);
	}
	
}
