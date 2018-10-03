package com.stackroute.juggler.moviesearch.services;

import java.util.List;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.moviesearch.domain.City;
import com.stackroute.juggler.moviesearch.domain.Movie;
import com.stackroute.juggler.moviesearch.exceptions.MovieNotFoundException;

public interface MovieSearchService {
	public String saveCity(City city);

	public City getByCity(String city);

	public List<Movie> getByTitle(String movieName)  ;

	public void consumeKafka(MovieSchedule movieschedule);

	
}
