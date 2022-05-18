package com.blogging.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DuplicateDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8920892624956756921L;
	
	public DuplicateDataException(String message) {
		super(message);
	}


}
