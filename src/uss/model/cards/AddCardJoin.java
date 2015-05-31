package uss.model.cards;

import next.jdbc.mysql.join.Join;

public class AddCardJoin extends Join<AddedCards, Card> {

	public AddCardJoin(AddedCards left, Card right) {
		super(left, right);
	}

	@Override
	public String getLeftOnFieldName() {
		return "cardId";
	}
	
	@Override
	public String getRightOnFieldName() {
		return "cardId";
	}

}
