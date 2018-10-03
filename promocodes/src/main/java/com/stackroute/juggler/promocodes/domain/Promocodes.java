package com.stackroute.juggler.promocodes.domain;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//domain object for promocodes

@Document
public class Promocodes {

	@Id
	public int codeId;
	public String code;
	public String image;
	public String description;
	public int amount;

	// No Arguments constructor
	public Promocodes() {
	}

	// All Arguments constructor
	public Promocodes(int codeId, String code, String image, String description, int amount) {
		super();
		this.codeId = codeId;
		this.code = code;
		this.image = image;
		this.description = description;
		this.amount = amount;
	}

	// List of all getters and setters
	public int getCodeId() {
		return codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Promocodes [codeId=" + codeId + ", code=" + code + ", image=" + image + ", description=" + description
				+ ", amount=" + amount + "]";
	}

}
