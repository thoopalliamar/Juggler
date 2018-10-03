package com.stackroute.juggler.recommendation.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.recommendation.domain.City;
import com.stackroute.juggler.recommendation.domain.Genre;
import com.stackroute.juggler.recommendation.domain.Language;
import com.stackroute.juggler.recommendation.domain.Movie;
import com.stackroute.juggler.recommendation.domain.Theatre;
import com.stackroute.juggler.recommendation.repositories.MovieRepository;
import com.stackroute.juggler.recommendation.repositories.TheatreRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;
//private TheatreRepository theatreRepository;
@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
		
	}


	@Override
	@KafkaListener(groupId = "movie", topics = "screenings", containerFactory = "movieKafkaListenerContainerFactory")
	public void getMovieNode(MovieSchedule movie) {
		System.out.println("1111111111111");
		
		Movie movieObj = new Movie();
		Movie movies;
		Theatre theater;
		List<Theatre> theaters = new ArrayList<Theatre>();
		String name=movie.getMovieName();
		Theatre theatreObj=new Theatre(movie.getTheatreId(),movie.getTheatreName(),movie.getTheatreLocation(),movie.getTheatreCity(),movie.getSeatLayout(),movie.getShowNumbers(),movie.getShowTimings(),movie.getWeekdays_Price(),movie.getWeekends_Price(),movie.getNumberOfSeats(),movie.getTypesOfSeats(),movie.getScreenedmovies(),movie.getRunningmovies());
			theaters.add(theatreObj);
			//System.out.println(theaters);
			movieObj.setMovieId(movie.getId());
			movieObj.setName(movie.getMovieName());
			movieObj.setMoviePoster(movie.getMoviePoster());
			movieObj.setSynopsis(movie.getSynopsis());
			movieObj.setMovieReleasedate(movie.getMovieReleaseDate());
			movieObj.setMovieDuration(movie.getMovieDuration());
			movieObj.setFormat(movie.getFormat());
			movieObj.setHero(movie.getActors());
			movieObj.setHeroine(movie.getActress());
			movieObj.setDirector(movie.getDirectors());
			movieObj.setReleasedInCity(movie.getTheatreCity());
			movieObj.setMovieGenres(movie.getMovieGenres());
			movieObj.setLanguage(movie.getLanguages());
			//movieObj.setTheatres(theaters);
			City cityObj = new City(movie.getTheatreCity());
			movieObj.setCity(cityObj);
			Language langObj = new Language(movie.getLanguages());
			movieObj.setLanguages(langObj);
			Genre genreObj = new Genre(movie.getMovieGenres());
			movieObj.setGenre(genreObj);
			System.out.println(movieObj.toString());
			movieRepository.save(movieObj);
			System.out.println("final");
		}
	

	@Override
	public List<Movie> getGenreBasedMoviesForUser(String emailId) {
		System.out.println("serviceimpl");
		return movieRepository.getGenreBasedMoviesForUser(emailId);
	}
	
	

	@Override
	public List<Movie> getLanguageBasedMoviesForUser(String emailId) {
		return movieRepository.getLanguageBasedMoviesForUser(emailId);
	}

	@Override
	public List<Movie> getGenreLanguageBasedMoviesForUser(String emailId) {
		return movieRepository.getGenreLanguageBasedMoviesForUser(emailId);
	}

//	@Override
//	public List<Movie> getByGenreAgeCity(String userName, String genreName, String cityName) {
//		return movieRepository.getByGenreAgeCity(userName, genreName, cityName);
//	}

}
