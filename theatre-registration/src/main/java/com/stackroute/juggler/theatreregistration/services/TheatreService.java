package com.stackroute.juggler.theatreregistration.services;

import com.stackroute.juggler.kafka.domain.Theatre;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreAlreadyExistsException;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreNotFoundException;

//interface to define methods that service should support 
public interface TheatreService {

	// To save the theatre details
	public Theatre saveTheatre(Theatre theatre) throws TheatreAlreadyExistsException;

	// To update the theatre details
	public Theatre updateTheatre(Theatre theatre) throws TheatreNotFoundException;

	// To get the theatre by using theatre-title from database
	public Theatre getTheatre(String theatreTitle) throws TheatreNotFoundException;
	
	public Theatre getEmailId(String email) throws TheatreNotFoundException;
	
	

}