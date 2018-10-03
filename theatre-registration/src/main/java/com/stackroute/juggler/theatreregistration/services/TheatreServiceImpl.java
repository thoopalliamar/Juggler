package com.stackroute.juggler.theatreregistration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.Theatre;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreAlreadyExistsException;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreNotFoundException;
import com.stackroute.juggler.theatreregistration.repository.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService {

	private TheatreRepository theatreRepository;

	// instance of repository
	@Autowired
	public TheatreServiceImpl(TheatreRepository registrationRepository) {

		this.theatreRepository = registrationRepository;
	}

	@Autowired
	// This is the topic name it wont be changed so "final static"
	private KafkaTemplate<String, Theatre> kafkaTemplate;
	private static final String TOPIC = "theater-details";

	// saves the theatre details to database
	@Override
	public Theatre saveTheatre(Theatre theatre) throws TheatreAlreadyExistsException {
		kafkaTemplate.send(TOPIC, theatre);
		if (!theatreRepository.existsByTheatreName(theatre.getTheatreName())) {
			Theatre theatreSaved = theatreRepository.save(theatre);
			return theatreSaved;
		} else
			throw new TheatreAlreadyExistsException("theatre already exists");
	}

	// to update the theatre details
	@Override
	public Theatre updateTheatre(Theatre theatre) {
//		kafkaTemplate.send(TOPIC, theatre);
		Theatre theatreUpdated = theatreRepository.save(theatre);

		return theatreUpdated;
	}

	// To the theatre by using theatre title from database
	@Override
	public Theatre getTheatre(String theatreTitle) {
		
		Theatre list = theatreRepository.getByTheatreName(theatreTitle);
		return list;
	}

	@Override
	public Theatre getEmailId(String email) throws TheatreNotFoundException {
		Theatre theatre = theatreRepository.getByEmail(email);
//		if (theatre.getTheatreName() == null) {
//			return "false";
//		}
		return theatre;
	}

}