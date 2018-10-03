package com.stackroute.juggler.recommendation.services;


import java.util.List;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.recommendation.domain.Movie;

public interface MovieService {
//	Movie findByMovieTitle(String movieTitle);
//	List<Movie> getByGenreAgeCity(@Param("userName") String userName,@Param("genreName")String genreName,@Param("cityName")String cityName);
//	Movie saveMovie(Movie movie);
	public void getMovieNode(MovieSchedule movie);

	public List<Movie> getGenreLanguageBasedMoviesForUser(String emailId);

	public List<Movie> getGenreBasedMoviesForUser(String emailId);

	public List<Movie> getLanguageBasedMoviesForUser(String emailId); 
	
	//public Movie findByName(String name);
	
//	public Movie findById(int id);
//    public void releasedIn(String cityName,int movieId);
	
//	public List<Movie> getMoviesByGenre(String genreName);
//
//	public List<Movie> getMoviesByCity(String cityName);
//
//	public List<Movie> getMovieByCityGenre(String cityName, String genreName);
//
//	public List<Movie> getMovieByCityLanguage(String cityName, String languageName);
//
//	public List<Movie> getMovieByCityGenreLanguage(String cityName, String genreName, String languageName);
}
