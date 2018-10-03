package com.stackroute.juggler.movieschedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.movieschedule.service.MovieScheduleService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class MovieScheduleController {

	// creating the MovieScheduleService object to use the methods in it
	private MovieScheduleService movieScheduleService;

	// Constructor
	@Autowired
	public MovieScheduleController(MovieScheduleService movieScheduleService) {
		this.movieScheduleService = movieScheduleService;
	}

	// save the movie theater-screening details to the database
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveMovieHandler(@RequestBody MovieSchedule movie) {

		MovieSchedule movieObj = movieScheduleService.addMovieSchedule(movie);

		return new ResponseEntity<MovieSchedule>(movieObj, HttpStatus.OK);

	}

	// get the movie theater-screening from the database
	@RequestMapping(value = "/show", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<MovieSchedule>> getMovieSchedule() {

		List<MovieSchedule> movieObj = movieScheduleService.getMoviesSchedule();
		return new ResponseEntity<List<MovieSchedule>>(movieObj, HttpStatus.OK);

	}

	// Update the movie theater-screening in the databases and message bus
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updateMovieSchedule(@RequestParam String email, @RequestBody MovieSchedule movie) {

		MovieSchedule movieObj = movieScheduleService.updateMovieSchedule(email, movie);

		return new ResponseEntity<MovieSchedule>(movieObj, HttpStatus.OK);

	}

}
