package com.stackroute.juggler.kafka.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserLikes {

	@Id
	private int userId;
	private String movie;

	
	//Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	//To String
	@Override
	public String toString() {
		return "UserLikes [userId=" + userId + ", movie=" + movie + "]";
	}

	
	//All Args Constructer
	public UserLikes(int userId, String movie) {
		super();
		this.userId = userId;
		this.movie = movie;
	}

	//No Args Constructer
	public UserLikes() {
		super();
	}

}
