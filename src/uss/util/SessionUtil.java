package uss.util;

import javax.servlet.http.HttpSession;

import uss.model.User;

public class SessionUtil {

	private static final String USER = "user";
	
	public static User getUser(HttpSession session) {
		return (User) session.getAttribute(USER);
	}

}
