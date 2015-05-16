package uss.model;

import next.jdbc.mysql.annotation.Column;
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
		this.phone = phoneNumber;
		this.profile = profile;
	}

	public User(String email) {
		this.email = email;
	}

	@Key(AUTO_INCREMENT = true)
	private Integer id;
	private String name;
	@Column(function = { "index", "unique" })
	private String email;
	private String password;
	private Integer template;
	private String job;
	private String phone;
	private String profile;
	private String bizemail;

	public String getBizemail() {
		return bizemail;
	}

	public void setBizemail(String bizemail) {
		this.bizemail = bizemail;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phoneNumber) {
		this.phone = phoneNumber;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void update(User updatedUser) {
		if (updatedUser.name != null)
			this.name = updatedUser.name;
		if (updatedUser.template != null)
			this.template = updatedUser.template;
		if (updatedUser.job != null)
			this.job = updatedUser.job;
		if (updatedUser.phone != null)
			this.phone = updatedUser.phone;
		if (updatedUser.profile != null)
			this.profile = updatedUser.profile;

	}

}
