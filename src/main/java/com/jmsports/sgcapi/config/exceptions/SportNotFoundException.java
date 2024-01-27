package com.jmsports.sgcapi.config.exceptions;

public class SportNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SportNotFoundException(String message) {
		super(message);
	}

}
