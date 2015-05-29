package uss.model;

import next.jdbc.mysql.annotation.Key;

public class GroupHasUser {

	@Key
	private Integer groupId;
	@Key
	private Integer userId;

}
