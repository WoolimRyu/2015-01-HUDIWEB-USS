package uss.model.cards;

import next.jdbc.mysql.annotation.Key;
import next.jdbc.mysql.annotation.Table;

@Table
public class MyCards {

	@Key
	private Integer userId;
	@Key
	private Integer cardId;
	private Integer groupId;

}
