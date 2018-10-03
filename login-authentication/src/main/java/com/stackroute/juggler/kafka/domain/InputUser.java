package com.stackroute.juggler.kafka.domain;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

// This domain object is used to save the data from the kafka
// this user_id is set as id
public class InputUser {
	@Id
	private String userId;
	@Size(min = 6, max = 20)
	private String userName;
	private String emailId;
	private double mobileNo;
	@Size(min = 8, max = 20)
	private String password;
	private String gender;
	private String dateOfBirth;

	private String[] genre;
	private String location;
	private String[] paymentMethods;
	private String likes;
	private String[] languagesKnown;

	public InputUser() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(double mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InputUser(String emailId, @Size(min = 8, max = 20) String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String[] getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(String[] languagesKnown) {
		languagesKnown = languagesKnown;
	}

	public String[] getGenre() {
		return genre;
	}

	public void setGenre(String[] genre) {
		this.genre = genre;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String[] getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(String[] paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public InputUser(String userId, @Size(min = 6, max = 20) String userName, String emailId, double mobileNo,
			@Size(min = 8, max = 20) String password, String gender, String dateOfBirth, String[] languagesKnown,
			String[] genre, String location, String[] paymentMethods, String likes) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		languagesKnown = languagesKnown;
		this.genre = genre;
		this.location = location;
		this.paymentMethods = paymentMethods;
		this.likes = likes;
	}

}
