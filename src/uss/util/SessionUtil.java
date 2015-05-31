package uss.util;

import javax.servlet.http.HttpSession;

import uss.model.User;
import uss.util.exception.SessionNullException;

public class SessionUtil {

	private static final String USER = "user";
	
	public static User getUser(HttpSession session) throws SessionNullException {
		User user = (User) session.getAttribute(USER);
		if(user == null)
			throw new SessionNullException();
		return user;
	}


}
