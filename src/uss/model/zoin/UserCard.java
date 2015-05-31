package uss.model.zoin;

import next.jdbc.mysql.join.Join;
import uss.model.User;
import uss.model.cards.Card;

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
