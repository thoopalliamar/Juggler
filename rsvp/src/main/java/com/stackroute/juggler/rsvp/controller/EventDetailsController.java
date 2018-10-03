package com.stackroute.juggler.rsvp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.stackroute.juggler.rsvp.config.KafkaConfiguration;
import com.stackroute.juggler.rsvp.domain.EventDetails;
import com.stackroute.juggler.rsvp.service.EventDetailsService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value ="api/v1")
public class EventDetailsController {

	private EventDetailsService eventDetailsService;
	
	
	@Autowired
	public EventDetailsController(EventDetailsService eventDetailsService){
	this.eventDetailsService =eventDetailsService;

	}	
	


	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public ResponseEntity<?> saveEvent(@RequestBody EventDetails eventDetails) {
		EventDetails savedEvent = eventDetailsService.saveEvent(eventDetails);
		return new ResponseEntity<EventDetails>(savedEvent, HttpStatus.OK);
	}
//	@RequestMapping(value = "/event/get", method = RequestMethod.GET)
//	public ResponseEntity<?> getEvent(@RequestParam String emailId) {
//	 
//		EventDetails existingEvent = eventDetailsService.getEvent(emailId);
//		return new ResponseEntity<EventDetails>(existingEvent, HttpStatus.OK);
//	}
	@RequestMapping(value = "/event/get", method = RequestMethod.GET)
	public ResponseEntity<?> getEvent(@RequestParam String emailId){
		List<EventDetails>existingEvent =eventDetailsService.getEvent(emailId);
		return new ResponseEntity<List<EventDetails>>(existingEvent, HttpStatus.OK);
	}
	@RequestMapping(value = "/event/name", method = RequestMethod.GET)
	public ResponseEntity<?> giveEvent(@RequestParam String eventName) {
	 
		EventDetails presentEvent = eventDetailsService.eventData(eventName);
		return new ResponseEntity<EventDetails>(presentEvent, HttpStatus.OK);
	}
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<?> AllEvent() {
	 
		List<EventDetails>eventList = eventDetailsService.getDetails();
		return new ResponseEntity<List<EventDetails>>(eventList, HttpStatus.OK);
	}
	
}
