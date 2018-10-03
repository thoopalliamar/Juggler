package com.stackroute.juggler.moviesearch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.moviesearch.domain.Movie;

@Repository // declaring it as repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {

	public List<Movie> getBymovieName(String movieName);

	public Movie findByMovieName(String movieName);

	public boolean existsByMovieName(String movieName);

	public Movie getById(String movieId);
}
