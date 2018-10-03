package com.stackroute.juggler.service;

import com.stackroute.juggler.kafka.domain.InputUser;
import com.stackroute.juggler.kafka.domain.User;

public interface UserService {
	// save the user
	User save(User user);

	// find user my email
	User findByEmail(String email);

	// consume message from kafka
	public void consumeKafka(InputUser User);

}
