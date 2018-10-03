package com.stackroute.juggler.promocodes.service;

import java.util.List;
import com.stackroute.juggler.promocodes.domain.Promocodes;

//This interface defines the methods that service should support
public interface PromocodesService {

	// save the promocode details to database
	public Promocodes save(Promocodes promocode);

	// get the promocode by codename
	public Promocodes getBycode(String code);

	// get all the promocodes from database
	public Iterable<Promocodes> getallpromocode();

}
