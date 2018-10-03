package com.stackroute.juggler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.User;

//using crudrepo to add into database
@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	User save(User user);

	// find data fom database by email and number
	User findByEmail(String email);

	
}
