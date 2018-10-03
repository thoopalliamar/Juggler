package com.stackroute.juggler.theatreregistration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.Theatre;

//Repository to perform operations on database
@Repository
public interface TheatreRepository extends CrudRepository<Theatre, Integer> {

	// get the theatre details by theatre-name from database
	public Theatre getByTheatreName(String theatre);
	
	public Theatre getByEmail(String email);

	// checks if the theatre with that particular name exists or not
	public boolean existsByTheatreName(String theatreName);
	
//	public Theatre getByEmail(String email);

}
