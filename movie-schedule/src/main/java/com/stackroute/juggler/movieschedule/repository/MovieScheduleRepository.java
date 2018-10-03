package com.stackroute.juggler.movieschedule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.MovieSchedule;

//declaring it as a repository
@Repository
public interface MovieScheduleRepository extends MongoRepository<MovieSchedule, Integer> {

	//These are the defined methods to be used when handling with database
	public MovieSchedule getByTheatreName(String theatreName);
	
	public MovieSchedule getByTheatreId(String theatreId);
	
	public MovieSchedule getByEmail(String email);
//	public boolean getEmail(String email);
}
