package uss.model.join;

import next.jdbc.mysql.join.Join;
import uss.model.Card;
import uss.model.User;

public class UserCard extends Join<User, Card> {

	public UserCard(User left, Card right) {
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
