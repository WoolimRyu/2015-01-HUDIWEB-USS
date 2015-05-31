package uss.model.cards;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class Card {

	@Key(AUTO_INCREMENT = true)
	private Integer cardId;
	private Integer userId;
	private String name;
	private String phoneNumber;
	private String email;
	private String company;
	private String companyAdress;
	private String position;
	private Integer template;
	private String photo;
	private String message;

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Card() {

	}

	public Card(Integer cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", userId=" + userId
				+ ", phoneNumber=" + phoneNumber + ", company=" + company
				+ ", position=" + position + ", template=" + template
				+ ", photo=" + photo + ", message=" + message + "]";
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getCompanyAdress() {
		return companyAdress;
	}

}
