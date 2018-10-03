package com.stackroute.juggler.promocodes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.juggler.promocodes.domain.Promocodes;

@Repository
public interface PromocodeRepository extends CrudRepository<Promocodes, String> {
	// Gets Promo details by code from database
	public Promocodes getBycode(String codename);

}
