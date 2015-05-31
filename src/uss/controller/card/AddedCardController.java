package uss.controller.card;

import java.util.List;

import javax.servlet.http.HttpSession;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.model.User;
import uss.model.cards.AddCardJoin;
import uss.model.cards.AddedCards;
import uss.model.cards.Card;
import uss.response.Response;
import uss.response.Result;
import uss.util.SessionUtil;

@RestController
@RequestMapping("/api/addcard")
public class AddedCardController {

	@Autowired
	private DAO dao;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Response cardAdd(HttpSession session, String cardId) {
		User user = SessionUtil.getUser(session);
		if(user == null)
			return Result.getErrorSessionExpired();
		AddedCards cards = new AddedCards(user.getUserId(),
				Integer.parseInt(cardId), null);
		if (!dao.insert(cards))
			return Result.getErrorSqlExcute();
		return Result.getSuccess();
	}

	@RequestMapping("/list")
	public Response cardList(HttpSession session) {
		User user = SessionUtil.getUser(session);
		if(user == null)
			return Result.getErrorBadRequest();
		AddCardJoin join = new AddCardJoin(new AddedCards(user.getUserId(),
				null, null), new Card());
		List<AddCardJoin> result = dao.findList(join);
		if (result == null)
			return Result.getErrorSqlExcute();
		return Result.getSuccess(result);
	}

}
