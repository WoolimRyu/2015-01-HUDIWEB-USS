package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class Card {

	@Key(AUTO_INCREMENT = true)
	private Integer cardId;
	private Integer userId;
	private String phoneNumber;
	private String company;
	private String position;
	private Integer template;
	private String photo;
	private String message;

	public Card() {

	}

	public Integer getCardId() {
		return cardId;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public String getPosition() {
		return position;
	}

	public Integer getTemplate() {
		return template;
	}

	public String getPhoto() {
		return photo;
	}

	public String getMessage() {
		return message;
	}

}
