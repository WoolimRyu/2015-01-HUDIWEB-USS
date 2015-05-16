package uss.model;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class GroupHasUser {

	@Key
	private Integer gId;
	private Integer uId;
	
	public GroupHasUser(Integer gId, Integer uId) {
		this.gId = gId;
		this.uId = uId;
	}

	public Integer getgId() {
		return gId;
	}

	public void setgId(Integer gId) {
		this.gId = gId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
	
}
