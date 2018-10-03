package com.stackroute.juggler.recommendation.services;

import com.stackroute.juggler.recommendation.domain.Genre;

public interface GenreService {
	public Genre findByName(String genreName);

	
}
