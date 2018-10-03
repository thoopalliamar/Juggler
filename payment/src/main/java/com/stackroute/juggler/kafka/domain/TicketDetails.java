package com.stackroute.juggler.kafka.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class TicketDetails {

	@Id
	private String bookingId;
	private String email;
	private String theatreName;
	private String showId;
	private String movieName;
	private List<Integer> bookedSeats;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String showTiming;
	private String bookingStatus;

	public TicketDetails() {
		super();
	}

		

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public TicketDetails(String bookingId, String email, String theatreName, String showId, String movieName,
			List<Integer> bookedSeats, String showTiming, String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.email = email;
		this.theatreName = theatreName;
		this.showId = showId;
		this.movieName = movieName;
		this.bookedSeats = bookedSeats;
		this.showTiming = showTiming;
		this.bookingStatus = bookingStatus;
	}



	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
