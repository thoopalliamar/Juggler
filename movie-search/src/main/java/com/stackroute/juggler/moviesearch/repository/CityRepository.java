package com.stackroute.juggler.moviesearch.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.moviesearch.domain.City;

//declaring it as repository
@Repository   
	public interface CityRepository extends CrudRepository<City,String> {
	
	public City getBycityName(String city);
			public City findBycityName(String cityName);
		
	}