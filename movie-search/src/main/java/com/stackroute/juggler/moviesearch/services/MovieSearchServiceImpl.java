package com.stackroute.juggler.moviesearch.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.moviesearch.MovieSearchApplication;
import com.stackroute.juggler.moviesearch.domain.City;
import com.stackroute.juggler.moviesearch.domain.Movie;
import com.stackroute.juggler.moviesearch.domain.Theatre;
import com.stackroute.juggler.moviesearch.repository.CityRepository;
import com.stackroute.juggler.moviesearch.repository.MovieRepository;

@Service
public class MovieSearchServiceImpl implements MovieSearchService {

	public static final Logger logger = LoggerFactory.getLogger(MovieSearchApplication.class);

	private MovieRepository movieRepository;
	private CityRepository cityRepository;

	@Autowired
	public MovieSearchServiceImpl(MovieRepository movieRepository, CityRepository cityrepository) {
		// LoggingController.logger.debug("------------searchService started--------");
		logger.debug("------------searchService started--------");
		this.movieRepository = movieRepository;
		this.cityRepository = cityrepository;
	}

	// save the city with movieslist and theaterslist
	@Override
	public String saveCity(City city) {

		City cityToBeSave = cityRepository.save(city);
		List<Movie> movies = convertcitytomovie(city);

		for (Iterator iterator = movies.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			Movie moviesaved = movieRepository.save(movie);
		}

		return "saved";

	}

	private List<Movie> convertcitytomovie(City city) {
		List<Movie> movies = city.getMovieList();
		return movies;
	}

	// get movies by cityName
	@Override
	public City getByCity(String city) {
		City list = cityRepository.getBycityName(city);
		return list;

	}

	// get movie by movieName
	@Override
	public List<Movie> getByTitle(String movieName) {

		List<Movie> list = movieRepository.getBymovieName(movieName);
		return list;

	}

	// listening from kafka from screening microservice
	@Override
	@KafkaListener(topics = "screening-details", groupId = "search", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka(MovieSchedule movieschedule) {

		logger.debug("-------------started the method-----------");
        boolean flag = false;
		int i, k = 0;
		City cities;
		Movie movie;
		Movie tempMovie;
		List<Movie> movies = new ArrayList<Movie>();
		List<Theatre> theaters = new ArrayList<Theatre>();
		List<Theatre> newtheater;
		Theatre theater;
		Theatre theatre1;
		String cityname = movieschedule.getTheatreCity();
		if (cityRepository.findBycityName(cityname) != null) {
			logger.debug("---------checking the city----------------");
			cities = cityRepository.findBycityName(cityname);
			movies = cities.getMovieList();
			Iterator<Movie> iterator = movies.iterator();
			i = 0;
			while (iterator.hasNext()) {
				movie = iterator.next();
				i++;
				if (movie.getMovieName().equals(movieschedule.getMovieName())) {
					flag = true;
					k = i;
					break;
				} else {
					flag = false;
				}
			}
			if (flag == true) {
				logger.debug("------checking the movies ------------- ");
				movie = movies.get(k - 1);
				theaters = movie.getTheatres();
				Iterator<Theatre> iterator1 = theaters.iterator();
				while (iterator1.hasNext()) {
					theater = iterator1.next();

					if (theater.getTheatreName().equals(movieschedule.getTheatreName())) {
						logger.debug("-----checking for theatre names-----");
					} else {
						theatre1 = new Theatre();	
						theatre1.setTheatreId(movieschedule.getTheatreId());
						theatre1.setTheatreName(movieschedule.getTheatreName());
						theatre1.setTheatreLocation(movieschedule.getTheatreLocation());
						theatre1.setSeatLayout(movieschedule.getSeatLayout());
						theatre1.setShowNumbers(movieschedule.getShowNumbers());
						String show=movieschedule.getShowTimings().trim();
						String[] showtiming=show.split(",");
						theatre1.setShowTimings(showtiming);
						theatre1.setWeekends_Price(movieschedule.getWeekends_Price());
						theatre1.setWeekdays_Price(movieschedule.getWeekdays_Price());
						theatre1.setTypesOfSeats(movieschedule.getTypesOfSeats());
						theatre1.setNumberOfSeats(movieschedule.getNumberOfSeats());
						theatre1.setScreenedmovies(movieschedule.getScreenedmovies());
						theatre1.setRunningmovies(movieschedule.getRunningmovies());
						theaters.add(theatre1);
						cityRepository.save(cities);
						  movieRepository.save(movie);
					}
				}
			} else {
				theatre1 = new Theatre();
				theatre1 = new Theatre();	
				theatre1.setTheatreId(movieschedule.getTheatreId());
				theatre1.setTheatreName(movieschedule.getTheatreName());
				theatre1.setTheatreLocation(movieschedule.getTheatreLocation());
				theatre1.setSeatLayout(movieschedule.getSeatLayout());
				theatre1.setShowNumbers(movieschedule.getShowNumbers());
				String show=movieschedule.getShowTimings().trim();
				String[] showtiming=show.split(",");
				theatre1.setShowTimings(showtiming);
				theatre1.setWeekends_Price(movieschedule.getWeekends_Price());
				theatre1.setWeekdays_Price(movieschedule.getWeekdays_Price());
				theatre1.setTypesOfSeats(movieschedule.getTypesOfSeats());
				theatre1.setNumberOfSeats(movieschedule.getNumberOfSeats());
				theatre1.setScreenedmovies(movieschedule.getScreenedmovies());
				theatre1.setRunningmovies(movieschedule.getRunningmovies());
				newtheater = new ArrayList<Theatre>();
				newtheater.add(theatre1);
				tempMovie = new Movie(movieschedule.getId(), movieschedule.getMovieName(),
						movieschedule.getMoviePoster(), movieschedule.getSynopsis(),
						movieschedule.getMovieReleaseDate(), movieschedule.getMovieDuration(),
						movieschedule.getLanguages(), movieschedule.getMovieGenres(), movieschedule.getFormat(),
						movieschedule.getActors(), movieschedule.getActress(), movieschedule.getDirectors(),
						newtheater);
				movies.add(tempMovie);
				cityRepository.save(cities);
				movieRepository.save(tempMovie);
			}
		} else {
			theater = new Theatre();
			theater.setTheatreId(movieschedule.getTheatreId());
			theater.setTheatreName(movieschedule.getTheatreName());
			theater.setTheatreLocation(movieschedule.getTheatreLocation());
			theater.setSeatLayout(movieschedule.getSeatLayout());
			theater.setShowNumbers(movieschedule.getShowNumbers());
			String show=movieschedule.getShowTimings().trim();
			String[] showtiming=show.split(",");
			theater.setShowTimings(showtiming);
			theater.setWeekends_Price(movieschedule.getWeekends_Price());
			theater.setWeekdays_Price(movieschedule.getWeekdays_Price());
			theater.setTypesOfSeats(movieschedule.getTypesOfSeats());
			theater.setNumberOfSeats(movieschedule.getNumberOfSeats());
			theater.setScreenedmovies(movieschedule.getScreenedmovies());
			theater.setRunningmovies(movieschedule.getRunningmovies());
			theaters = new ArrayList<Theatre>();
			theaters.add(theater);
			movie = new Movie(movieschedule.getId(), movieschedule.getMovieName(), movieschedule.getMoviePoster(),
					movieschedule.getSynopsis(), movieschedule.getMovieReleaseDate(), movieschedule.getMovieDuration(),
					movieschedule.getLanguages(), movieschedule.getMovieGenres(), movieschedule.getFormat(),
					movieschedule.getActors(), movieschedule.getActress(), movieschedule.getDirectors(), theaters);
			movies = new ArrayList<>();
			movies.add(movie);
			cities = new City(cityname, movies);
			cityRepository.save(cities);
			movieRepository.save(movie);
	}

	}
}

	
	


