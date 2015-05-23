package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class User {
	@Key(AUTO_INCREMENT=true)
	private Integer id;
	
	private String stringId;
	private String password;
	private String email;
	private String name;

	public Integer getId() {
		return id;
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
