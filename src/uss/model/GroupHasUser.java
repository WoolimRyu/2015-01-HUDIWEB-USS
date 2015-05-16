package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class GroupHasUser {

	@Key
	private Integer groupId;
	private Integer userId;

	public GroupHasUser(Integer groupId, Integer userId) {
		this.groupId = groupId;
		this.userId = userId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
