package uss.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;

import next.jdbc.mysql.DAO;
import next.jdbc.mysql.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.model.User;
import uss.model.cards.Card;
import uss.response.Response;
import uss.response.Result;
import uss.util.SessionUtil;

@RestController
@RequestMapping("/api/card")
public class CardController {

	@Autowired
	DAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public Response get(User user) {
		User u = dao.find(user);
		Card card = new Card(u.getRepresentiveCardId());
		Card c = dao.find(card);
		return Result.getSuccess(c);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Response newCard(HttpSession session) {
		DAO dao = new DAO(new Transaction());
		Card card = new Card();
		User user = SessionUtil.getUser(session);
		if(user == null)
			return Result.getErrorSessionExpired();
		card.setUserId(user.getUserId());
		if (!dao.insert(card))
			return Result.getErrorSqlExcute();
		BigInteger id = (BigInteger) dao.getRecordAsList(
				"SELECT LAST_INSERT_ID();").get(0);
		SessionUtil.setCardId(session, id.intValue());
		user.setRepresentiveCardId(id.intValue());
		dao.update(user);
		dao.close();
		return Result.getSuccess(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Response update(Card card, HttpSession session) {
		User user = SessionUtil.getUser(session);
		if(user == null)
			return Result.getErrorSessionExpired();
		Integer cardId = SessionUtil.getCardId(session);
		if (cardId == null)
			cardId = user.getRepresentiveCardId();
		card.setCardId(cardId);
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
