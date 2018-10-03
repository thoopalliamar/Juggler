package com.stackroute.juggler.moviesearch.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
// Domain object for movie details
public class Movie {
	@Id
	private String movieId;
	private String movieName;
	private String moviePoster;
	private String synopsis;
	private String movieReleasedate;
	private String movieDuration;
	private String languages;
	private String movieGenre;
	private String format;
	private String hero;
	private String heroine;
	private String director;
	private List<Theatre> theatres;

	// All Arguments constructor
	public Movie(String movieId, String movieName, String moviePoster, String synopsis, String movieReleasedate,
			String movieDuration, String languages, String movieGenre, String format, String hero, String heroine,
			String director, List<Theatre> theatres) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.moviePoster = moviePoster;
		this.synopsis = synopsis;
		this.movieReleasedate = movieReleasedate;
		this.movieDuration = movieDuration;
		this.languages = languages;
		this.movieGenre = movieGenre;
		this.format = format;
		this.hero = hero;
		this.heroine = heroine;
		this.director = director;
		this.theatres = theatres;
	}

	// No argument constructor
	public Movie() {
		super();
	}

	// List of all getters and setters
	public String getId() {
		return movieId;
	}

	public void setId(String id) {
		this.movieId = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getMovieReleasedate() {
		return movieReleasedate;
	}

	public void setMovieReleasedate(String movieReleasedate) {
		this.movieReleasedate = movieReleasedate;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguage(String languages) {
		this.languages = languages;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHeroine() {
		return heroine;
	}

	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}

}
