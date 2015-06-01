package uss.model.cards;

import next.jdbc.mysql.annotation.Column;
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
	private String companyAddress;
	private String mapSrc;
	private String position;
	@Column(DEFAULT="1")
	private Integer template;
	private String photo;
	private String message;
	public String getMapSrc() {
		return mapSrc;
	}

	public void setMapSrc(String mapSrc) {
		this.mapSrc = mapSrc;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Card() {

	}
	
	

	public Card(Integer userId, String name, String phoneNumber, String email,
			String company, String companyAddress, String mapSrc,
			String position, Integer template) {
		super();
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.company = company;
		this.companyAddress = companyAddress;
		this.mapSrc = mapSrc;
		this.position = position;
		this.template = template;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setTemplate(Integer template) {
		this.template = template;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

}
