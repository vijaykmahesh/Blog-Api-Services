package com.blogging.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class DataNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -104758023870252518L;

	/**
	 * 
	 */

	public DataNotFoundException(String message) {
		super(message);
	}

}
