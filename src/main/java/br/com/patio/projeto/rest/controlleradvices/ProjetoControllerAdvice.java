package br.com.patio.projeto.rest.controlleradvices;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.patio.projeto.errordto.ProjetoPatternError;
import br.com.patio.projeto.exceptions.DataDuplicityException;
import br.com.patio.projeto.exceptions.NotFoundException;

@RestControllerAdvice
public class ProjetoControllerAdvice {

	private ProjetoPatternError createError(String status, String message, String detail) {
		ProjetoPatternError ProjetoPatternError = new ProjetoPatternError();
		ProjetoPatternError.setStatus(status);
		ProjetoPatternError.setMessage(message);
		ProjetoPatternError.setDetailMessage(detail);
		ProjetoPatternError.setTimestamp((new Date()).getTime());
		return ProjetoPatternError;
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public ResponseEntity<ProjetoPatternError> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException mnaex) {
		ProjetoPatternError ProjetoPatternError = createError(
				HttpStatus.METHOD_NOT_ALLOWED.toString(), 
				"Recurso não encontrado", 
				mnaex.getMessage());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(ProjetoPatternError);
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ProjetoPatternError> notFoundException(NotFoundException nfex) {
		ProjetoPatternError ProjetoPatternError = createError(
				HttpStatus.NOT_FOUND.toString(), 
				"Identificador não encontrado no banco de dados", 
				nfex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ProjetoPatternError);
	}
	
	@ExceptionHandler(DataDuplicityException.class)
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	public ResponseEntity<ProjetoPatternError> dataDuplicityException(DataDuplicityException dde) {
		ProjetoPatternError ProjetoPatternError = createError(
				HttpStatus.PRECONDITION_FAILED.toString(), 
				"Dados serão duplicados: " + dde.getMessage() ,
				dde.getMessage());
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(ProjetoPatternError);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ProjetoPatternError> argumentNotValidException(MethodArgumentNotValidException manve) {
		ProjetoPatternError ProjetoPatternError = createError(
				HttpStatus.BAD_REQUEST.toString(),
				"Campos obrigatórios não preenchidos", 
				manve.getMessage()); 
				
		BindingResult result = manve.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			ProjetoPatternError.addErrorDetail(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ProjetoPatternError);
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ProjetoPatternError> otherExceptions(Exception mnaex) {
		ProjetoPatternError ProjetoPatternError = createError(
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), 
				"Erro de execução interna do servidor, contate Administrador!", 
				mnaex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ProjetoPatternError);
	}
	
}
