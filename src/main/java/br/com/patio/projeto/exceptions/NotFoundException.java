package br.com.patio.projeto.exceptions;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
