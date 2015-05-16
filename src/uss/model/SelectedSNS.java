package uss.model;

import next.jdbc.mysql.annotation.Exclude;
import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class SelectedSNS {

	@Exclude
	public static final int FACEBOOK = 0;
	@Exclude
	public static final int TWITTER = 1;
	@Exclude
	public static final int INSTAGRAM = 2;
	@Exclude
	public static final int GITHUB = 3;
	@Exclude
	public static final int LINKEDIN = 4;
	@Exclude
	public static final int SLIDESHARE = 5;
	@Exclude
	public static final int YOUTUBE = 6;
	@Exclude
	public static final int TUMBLER = 7;

	@Key
	private int userId;
	@Key
	private Integer snsType;
	private String snsId;

	public SelectedSNS(int userId, Integer snsType, String snsId) {
		this.userId = userId;
		this.snsType = snsType;
		this.snsId = snsId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Integer getSnsType() {
		return snsType;
	}

	public void setSnsType(Integer snsType) {
		this.snsType = snsType;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

}
