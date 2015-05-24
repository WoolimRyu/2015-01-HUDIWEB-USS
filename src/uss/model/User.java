package uss.model;

import next.jdbc.mysql.annotation.Column;
import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class User {
	@Key(AUTO_INCREMENT = true)
	private Integer userId;

	@Column(function = { "index", "unique" })
	private String stringId;
	private String password;
	private String email;
	private String name;
	private String style;

	public User() {
	}

	public User(String stringId, String password) {
		this.stringId = stringId;
		this.password = password;
	}

	public User(String stringId, String password, String email, String name, String style) {
		this.stringId = stringId;
		this.password = password;
		this.email = email;
		this.name = name;
		this.style = style;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", stringId=" + stringId + ", password=" + password + ", email=" + email + ", name=" + name + "]";
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setUserId(Integer id) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((stringId == null) ? 0 : stringId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (stringId == null) {
			if (other.stringId != null)
				return false;
		} else if (!stringId.equals(other.stringId))
			return false;
		return true;
	}

}
