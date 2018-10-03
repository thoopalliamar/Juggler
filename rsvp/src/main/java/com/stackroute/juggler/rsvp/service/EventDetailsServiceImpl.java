package com.stackroute.juggler.rsvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.rsvp.config.KafkaConfiguration;
import com.stackroute.juggler.rsvp.domain.EventDetails;
import com.stackroute.juggler.rsvp.repository.EventRepository;
@Service
public class EventDetailsServiceImpl implements EventDetailsService {

	private EventRepository eventRepository;
	//private KafkaConfiguration eventDetailsConfig;
	@Autowired
	public EventDetailsServiceImpl(EventRepository eventRepository	) {
		this.eventRepository=eventRepository;
		// this.eventDetailsConfig=eventDetailsConfig;
	
	}
	String topic =KafkaConfiguration.getTopic();
	// Kafka template from configuration and topic
	@Autowired
	private KafkaTemplate<String, EventDetails> kafkaTemplate;

	
	@Override
	public EventDetails saveEvent(EventDetails eventDetails) {
		kafkaTemplate.send(topic,eventDetails );
		EventDetails savedEvent=eventRepository.save(eventDetails);
		return  savedEvent;
	}

//	@Override
//	public List<EventDetails> getEvent(String emailId) {
//		List<EventDetails> existingEvent=eventRepository.getByEmailId(emailId);
//		return existingEvent;
//	}

	@Override
	public EventDetails eventData(String eventName) {
		EventDetails eventData=eventRepository.getByEventName(eventName);
		return eventData;
	}

	@Override
	public List<EventDetails> getDetails() {
		List<EventDetails> eventDetailsList = (List<EventDetails>)eventRepository.findAll();
		return eventDetailsList;
	}

	@Override
	public List<EventDetails> getEvent(String emailId) {
		// TODO Auto-generated method stub
		List<EventDetails> eventList=eventRepository.getByEmailId(emailId);
		return eventList;
	}
	

}
