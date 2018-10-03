package com.stackroute.juggler.distributor.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.juggler.distributor.domain.Movie;
import com.stackroute.juggler.distributor.repositary.MovieRepositary;

//This service implementations gives the functionality
@Service
public class ServicesImpl implements Services {

	// Instance of repository
	@Autowired
	private MovieRepositary movieRepositary;

	// @Autowired
	public ServicesImpl(MovieRepositary movieRepository) {
		this.movieRepositary = movieRepositary;
	}

	// This saves the movie to database
	@Override
	public Movie saveMovie(Movie movie) {
		Movie savedMovie = movieRepositary.save(movie);
		return savedMovie;

	}

	// This gets the movie from database by movie title
	@Override
	public List<Movie> getByMovieTitle(String movieTitle) {
		List<Movie> movies = movieRepositary.getByMovieName(movieTitle);
		return movies;
	}

	// This gets all the movies from the database
	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = (List<Movie>) movieRepositary.findAll();
		return movies;
	}

}
