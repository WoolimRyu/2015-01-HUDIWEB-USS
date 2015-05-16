package uss.model;

import next.jdbc.mysql.annotation.Column;
import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class Group {

	@Key(AUTO_INCREMENT = true)
	private Integer id;
	@Column(function = "index")
	private Integer userId;
	private String name;

	public Group(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

}