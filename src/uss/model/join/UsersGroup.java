package uss.model.join;

import uss.model.Group;
import next.jdbc.mysql.join.Join;

public class UsersGroup extends Join<Group, GroupUser> {

	public UsersGroup(Group left, GroupUser right) {
		super(left, right);
	}

	@Override
	public String getLeftOnFieldName() {
		return "groupId";
	}

	@Override
	public String getRightOnFieldName() {
		return "GroupHasUser.groupId";
	}

	@Override
	public String toString() {
		return "UsersGroup [left=" + left + ", right=" + right + "]";
	}

}
