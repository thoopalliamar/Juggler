package com.stackroute.juggler.userprofile.exceptions;
//This exception is thrown when the InputUser want to update the profile
//which does not exits in the database
public class UpdateFailedException extends Exception{
	
	public UpdateFailedException(String s)
	{
		super(s);
	}
}
