package com.stackroute.juggler.moviesearch.exceptions;

public class MovieNotFoundException extends Exception {
	// throws MovieNotFound exception, if Movie is not found
	public MovieNotFoundException(String msg) {
		super(msg);
	}
}
