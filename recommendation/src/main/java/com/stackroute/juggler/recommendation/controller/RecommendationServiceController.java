package com.stackroute.juggler.recommendation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.recommendation.domain.Movie;
import com.stackroute.juggler.recommendation.services.MovieService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RecommendationServiceController {

	 MovieService movieService;
//private UserRepository userRepository;
//	private UserService userService;

	@Autowired
	public RecommendationServiceController(MovieService movieService) {
		super();
		this.movieService = movieService;
//		this.userService = userService;
	}

//
//	@GetMapping("/getMoviesByGenre/{genreName}")
//	public ResponseEntity<?> getMoviesByGenre(@PathVariable String genreName) {
//		return new ResponseEntity<List<Movie>>(movieService.getMoviesByGenre(genreName), HttpStatus.OK);
//	}
//
//	@GetMapping("/getMoviesByCityGenre/{cityName}&{genreName}")
//	public ResponseEntity<List<Movie>> getMovieByCityGenre(@PathVariable String cityName,
//			@PathVariable String genreName) {
//		return new ResponseEntity<List<Movie>>(movieService.getMovieByCityGenre(cityName, genreName), HttpStatus.OK);
//	}



	@GetMapping("/getGenreBasedMoviesForUser/{emailId}")
	public ResponseEntity<List<Movie>> getGenreBasedMoviesForUser(@PathVariable String emailId) {
		System.out.println("hello"+ emailId);
		return new ResponseEntity<List<Movie>>(movieService.getGenreBasedMoviesForUser(emailId), HttpStatus.OK);
	}

	@GetMapping("/getLanguageBasedMoviesForUser/{emailId}")
	public ResponseEntity<List<Movie>> getLanguageBasedMoviesForUser(@PathVariable String emailId) {
		System.out.println("hello");
		return new ResponseEntity<List<Movie>>(movieService.getLanguageBasedMoviesForUser(emailId), HttpStatus.OK);
	}
	
	@GetMapping("/getGenreLanguageBasedMoviesForUser/{emailId}")
	public ResponseEntity<List<Movie>> getGenreLanguageBasedMoviesForUser(@PathVariable String emailId) {
		System.out.println("hello");
		return new ResponseEntity<List<Movie>>(movieService.getGenreLanguageBasedMoviesForUser(emailId), HttpStatus.OK);
	}
}