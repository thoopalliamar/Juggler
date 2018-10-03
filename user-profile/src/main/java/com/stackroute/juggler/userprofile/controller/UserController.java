package com.stackroute.juggler.userprofile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.kafka.domain.InputUser;
import com.stackroute.juggler.kafka.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExitsException;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailedException;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExistsException;
import com.stackroute.juggler.userprofile.service.UserService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/userProfile")
@RestController
public class UserController {

	// creating the userservice object to use the methods in it
	private UserService userService;

	//logger is used to log status of code
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// constructer
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// mapping is to accept new user and save the data to database and messagebus
	@RequestMapping(value = "/regestration", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody InputUser inputUser) throws ProfileAlreadyExitsException {
		// InputUser userobj = null;
		try {
			InputUser userobj = userService.saveUser(inputUser);
			System.out.println(inputUser.getLanguagesKnown());
			System.out.println(inputUser.getDateOfBirth());
			logger.info("movie is saved into database");
			return new ResponseEntity<InputUser>(userobj, HttpStatus.CREATED);
		} catch (ProfileAlreadyExitsException m) {
			// Error handling code
			String result = m.getMessage();
			logger.warn("movie is not added into database");
			return new ResponseEntity<String>(result, HttpStatus.CONFLICT);
		}

	}

	// Views the user in the database we take user id in url itself
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> viewuser(@PathVariable String userid) throws UserDoesNotExistsException {
		try {
			InputUser userobj = userService.viewUser(userid);
			logger.info("InputUser retrived from database");
			return new ResponseEntity<InputUser>(userobj, HttpStatus.FOUND);
		} catch (UserDoesNotExistsException m) {
			// Error Handling
			String result = m.getMessage();
			logger.warn("movie is not found in database");
			return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
		}

	}

	//Updates user initially we find the user and allow to update
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateuser(@PathVariable String userid, @RequestBody UserProfile user)
			throws UpdateFailedException, UserDoesNotExistsException {
		try {
			InputUser userobj = userService.updateUser(userid, user);
			logger.info("InputUser updated");
			return new ResponseEntity<InputUser>(userobj, HttpStatus.OK);
		} catch (UserDoesNotExistsException m) {
			// Error handling
			String result = m.getMessage();
			logger.warn("movie is not updated");
			return new ResponseEntity<String>(result, HttpStatus.NOT_MODIFIED);
		}

	}

}
