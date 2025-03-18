package com.br.jotab.expections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public RequiredNotFoundException(String msg) {
		super(msg);
	}
	
	public RequiredNotFoundException() {
		super("It Allowed Not nulll ID");
	}


}
