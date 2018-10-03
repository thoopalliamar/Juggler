package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Theatre;

//MovieScheduleService class should implement these methods for sure
public interface MovieScheduleService {

	// add the movie theater-screening details
	public MovieSchedule addMovieSchedule(MovieSchedule movieSchedule);

	// get the movie theater-screening details
	public List<MovieSchedule> getMoviesSchedule();

	// update the movie theater-screening details
	public MovieSchedule updateMovieSchedule(String email, MovieSchedule updateMovie);

	// consume theater details from message bus
	public void consumeKafka(Theatre theatre);
	
//	public MovieSchedule getEmailid();

}
