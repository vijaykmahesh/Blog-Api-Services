package com.blogging.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ErrorWhileCreatingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8819388386726781510L;

	public ErrorWhileCreatingException(String message) {
		super(message);
	}

}
