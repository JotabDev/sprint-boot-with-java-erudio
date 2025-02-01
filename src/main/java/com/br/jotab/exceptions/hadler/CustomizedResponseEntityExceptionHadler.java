package com.br.jotab.exceptions.hadler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.jotab.exceptions.ExceptionResponse;
import com.br.jotab.exceptions.InsupportedMathOperationException;

@RestControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHadler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> hadlerAllException(
			Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> hadlerBadRequestException(
			Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
