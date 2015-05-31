package uss.util;

import javax.servlet.http.HttpSession;

import uss.model.User;
import uss.util.exception.SessionNullException;

public class SessionUtil {

	private static final String USER = "user";

	public static User getUser(HttpSession session) throws SessionNullException {
		User user = (User) session.getAttribute(USER);
		return user;
	}

	private static final String CARD_ID = "cardId";

	public static void setCardId(HttpSession session, int cardId) {
		session.setAttribute(CARD_ID, cardId);
	}

	public static Integer getCardId(HttpSession session) {
		Integer cardId = (Integer) session.getAttribute(CARD_ID);
		return cardId;
	}

	public static void logout(HttpSession session) {
		session.removeAttribute(USER);
	}


}
