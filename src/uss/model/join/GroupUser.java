package uss.model.join;

import next.jdbc.mysql.join.Join;
import uss.model.GroupHasUser;
import uss.model.User;

public class GroupUser extends Join<GroupHasUser, User> {

	public GroupUser(GroupHasUser left, User right) {
		super(left, right);
	}

	@Override
	public String getLeftOnFieldName() {
		return "userId";
	}

	@Override
	public String getRightOnFieldName() {
		return "userId";
	}

}
