package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class User {

	public User(Integer id, String name, String email, String password, Integer template, String job, String phoneNumber, String profile) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.template = template;
		this.job = job;
		this.phoneNumber = phoneNumber;
		this.profile = profile;
	}

	public User(String email) {
		this.email = email;
	}

	@Key(AUTO_INCREMENT = true)
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Integer template;
	private String job;
	private String phoneNumber;
	private String profile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTemplate() {
		return template;
	}

	public void setTemplate(Integer template) {
		this.template = template;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Object[] getInsertParameters() {
		return new Object[] { name, email, password, template, job, phoneNumber, profile };
	}

	public Object[] getUpdateParameters() {
		return new Object[] { name, email, password, template, job, phoneNumber, profile };
	}

}
