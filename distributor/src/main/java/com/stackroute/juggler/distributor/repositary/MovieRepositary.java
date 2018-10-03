package com.stackroute.juggler.distributor.repositary;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.distributor.domain.Movie;

//This repository is used to perform various operations on database
@Repository
public interface MovieRepositary extends MongoRepository<Movie, String> {

	// Gets movie details by title from database
	public List<Movie> getByMovieName(String movieName);

	// Gets movie details by Id from database
	public Movie getById(String id);

}
