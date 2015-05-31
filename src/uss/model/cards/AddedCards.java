package uss.model.cards;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class AddedCards {

	@Key
	private Integer userId;
	@Key
	private Integer cardId;
	private Integer groupId;

	public AddedCards(Integer userId, Integer cardId, Integer groupId) {
		this.userId = userId;
		this.cardId = cardId;
		this.groupId = groupId;
	}

}
