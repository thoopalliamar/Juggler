package com.stackroute.juggler.exceptions;

// Exception is thrown when the password does not match with the database details
public class PasswordNotMatchException extends Exception {

	private static final long serialVersionUID = 1L;

	String message;

	public PasswordNotMatchException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

}
