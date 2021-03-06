package com.blogging.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ErrorWhileUpdatingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2567689389089554676L;

	public ErrorWhileUpdatingException(String message) {
		super(message);
	}

}
