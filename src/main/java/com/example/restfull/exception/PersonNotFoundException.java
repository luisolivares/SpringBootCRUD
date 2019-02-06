package com.example.restfull.exception;

public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = 6032355007530181775L;

	public PersonNotFoundException() {
		super();
	}

	public PersonNotFoundException(final String message) {
		super(message);
	}

}
