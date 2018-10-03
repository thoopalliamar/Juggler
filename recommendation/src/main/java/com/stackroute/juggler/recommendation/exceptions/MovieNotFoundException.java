package com.stackroute.juggler.recommendation.exceptions;

public class MovieNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;    
	public MovieNotFoundException(String message) {
        super(message);
    }
}
