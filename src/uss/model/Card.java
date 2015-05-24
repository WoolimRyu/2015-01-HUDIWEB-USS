package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class Card {
<<<<<<< HEAD

=======
>>>>>>> 05b683209e552a75f6c33483ff78eea8acd94e0d
	@Key(AUTO_INCREMENT = true)
	private Integer id;

	private Integer userId;
	private String phoneNumber;
	private String company;
	private String position;
	private Integer template;
	private String photo;
	private String message;

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
