package com.stackroute.juggler.userprofile.service;

import com.stackroute.juggler.kafka.domain.InputUser;
import com.stackroute.juggler.kafka.domain.Movie;
import com.stackroute.juggler.kafka.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExitsException;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailedException;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExistsException;


//user service class should implement these methods for sure
public interface UserService {
	
	//Saves the user
	public InputUser saveUser(InputUser inputUser) throws ProfileAlreadyExitsException ;
	//Views the user
	public InputUser viewUser(String userId) throws UserDoesNotExistsException;
	//Updates the user
	public InputUser updateUser(String userId, UserProfile user) throws UpdateFailedException,UserDoesNotExistsException;
	
	
}
