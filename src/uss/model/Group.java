package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class Group {
	@Key(AUTO_INCREMENT = true)
	private Integer groupId;
	private Integer userId;
	private String name;
	private String description;

	public Integer getGroupId() {
		return groupId;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", userId=" + userId + ", name=" + name + ", description=" + description + "]";
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
