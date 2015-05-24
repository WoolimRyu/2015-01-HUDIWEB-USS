package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class Group {
	@Key(AUTO_INCREMENT=true)
	private Integer groupId;
		private String name;
	private String description;
	
	public Integer getGroupId() {
		return groupId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	
}
