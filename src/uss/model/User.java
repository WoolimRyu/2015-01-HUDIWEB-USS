package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class User {
	@Key(AUTO_INCREMENT = true)
	private Integer userId;

	private String stringId;
	private String password;
	private String email;
	private String name;

	public User(String stringId, String password) {
		this.stringId = stringId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", stringId=" + stringId + ", password=" + password + ", email=" + email + ", name="
				+ name + "]";
	}

	public void setId(Integer id) {
		this.userId = id;
	}

	public void setStringId(String stringId) {
		this.stringId = stringId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getStringId() {
		return stringId;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

}
