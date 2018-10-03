package com.stackroute.juggler.exceptions;

// Exception is thrown when one of the required fields is not entered during login
public class UserNameOrPasswordOrRoleEmpty extends Exception {
	private static final long serialVersionUID = 1L;

	String message;

	public UserNameOrPasswordOrRoleEmpty(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}
}