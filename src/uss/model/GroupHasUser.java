package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class GroupHasUser {

	@Key
	private Integer groupId;
	@Key
	private Integer userId;

	public GroupHasUser(Integer groupId, Integer userId) {
		super();
		this.groupId = groupId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "GroupHasUser [groupId=" + groupId + ", userId=" + userId + "]";
	}
	
	

}
