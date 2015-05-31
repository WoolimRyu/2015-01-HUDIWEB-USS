package uss.controller;

import java.util.List;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.model.cards.Card;
import uss.response.Response;
import uss.response.Result;

@RequestMapping("/api/card")
public class CardController {

	@Autowired
	DAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public Response get(Card card) {
		Card c = dao.find(card);
		if (c == null)
			return Result.getErrorSearchNotFound();
		return Result.getSuccess(c);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Response insert(Card card) {
		if (!dao.insert(card))
			return Result.getErrorSqlExcute();
		return Result.getSuccess();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Response update(Card card) {
		if (!dao.update(card))
			return Result.getErrorSqlExcute();
		return Result.getSuccess();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getList(Card card) {
		List<Card> cardList = dao.findList(card);
		if (cardList == null)
			return Result.getErrorSearchNotFound();
		return Result.getSuccess(cardList);
	}
}
