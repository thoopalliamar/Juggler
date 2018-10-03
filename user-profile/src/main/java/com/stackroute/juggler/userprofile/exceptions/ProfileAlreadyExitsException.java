package com.stackroute.juggler.userprofile.exceptions;

//This exception is thrown when the InputUser want to create the profile
//which already exits in the database
public class ProfileAlreadyExitsException extends Exception {

	public ProfileAlreadyExitsException(String s) {
		super(s);
	}

}
