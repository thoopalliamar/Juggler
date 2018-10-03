package com.stackroute.juggler.theatreregistration.exceptions;

public class TheatreAlreadyExistsException extends Exception {

	// throws TheatreAlreadyExists exception, if the theatre with same name is posted
	public TheatreAlreadyExistsException(String s) {
		super(s);
	}

}