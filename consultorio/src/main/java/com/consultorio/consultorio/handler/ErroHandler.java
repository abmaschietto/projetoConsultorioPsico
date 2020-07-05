package com.consultorio.consultorio.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<Error> handler(MethodArgumentNotValidException ex) {
		List<FieldError> fields = ex.getBindingResult().getFieldErrors();
		List<Error> erros = new ArrayList<Error>();
		fields.forEach(field ->{
			String nome = field.getField();
			String message = messageSource.getMessage(field, LocaleContextHolder.getLocale());
			Error erro = new Error(nome, message);
			erros.add(erro);
		});
		
		return erros;
		
	}

}
