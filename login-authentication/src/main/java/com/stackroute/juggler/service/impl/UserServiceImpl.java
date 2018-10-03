package com.stackroute.juggler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.InputUser;
import com.stackroute.juggler.kafka.domain.User;
import com.stackroute.juggler.repository.UserRepo;
import com.stackroute.juggler.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userDao;

	public User save(User user) {
		return userDao.save(user);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	// Listen the details from the kafka
	@Override
	@KafkaListener(topics = "details11", groupId = "userlogin")
	public void consumeKafka(InputUser inputUser) {

		User user = new User();

		if (userDao.findByEmail(inputUser.getEmailId()) == null) {
			String email = inputUser.getEmailId();
			String password = inputUser.getPassword();
			user.setEmail(email);
			user.setPassword(password);
			user.setRole("user");
			// save the details to the database
			userDao.save(user);

		}
	}

}
