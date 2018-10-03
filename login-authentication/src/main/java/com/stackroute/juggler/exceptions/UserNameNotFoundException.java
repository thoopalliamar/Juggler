package com.stackroute.juggler.exceptions;

// exception is thrown when (email)user name is not present in the back end data
public class UserNameNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	String message;

	public UserNameNotFoundException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

}