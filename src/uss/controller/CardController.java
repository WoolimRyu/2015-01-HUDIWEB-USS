package uss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.dao.CardDao;
import uss.model.Card;
import uss.response.Response;
import uss.response.Result;

@RequestMapping("/card")
public class CardController {

	@Autowired
	CardDao dao;

	@RequestMapping(method = RequestMethod.GET)
	public Response get(Card card) {
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Response insert(Card card) {
		if(!dao.insert(card))
			return Result.ERROR_SQL_EXCUTE;
		return Result.SUCCESS;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Response update(Card card) {
		if(!dao.update(card))
			return Result.ERROR_SQL_EXCUTE;
		return Result.SUCCESS;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getList(Card card) {
		List<Card> cardList = dao.findList(card);
		if (cardList == null)
			return Result.ERROR_SEARCH_NOT_FOUND;
		return Result.SUCCESS(cardList);
	}
}
