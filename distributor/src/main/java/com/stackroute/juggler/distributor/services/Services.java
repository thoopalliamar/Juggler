package com.stackroute.juggler.distributor.services;

import java.util.List;

import com.stackroute.juggler.distributor.domain.Movie;

//This interface defines the methods that service should support
public interface Services {

	// This saves movie
	public Movie saveMovie(Movie movie);

	// This gets movie details from database by movie title
	public List<Movie> getByMovieTitle(String movieTitle);

	// This gets all the movies from the database
	public List<Movie> getAllMovies();

}
