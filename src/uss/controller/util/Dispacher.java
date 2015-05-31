package uss.controller.util;

import javax.servlet.http.HttpSession;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.constants.UriPath;
import uss.model.User;
import uss.util.SessionUtil;

@Controller
public class Dispacher {

	@Autowired
	DAO dao;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String search(@PathVariable String userId, HttpSession session) {
		User user = dao.find(new User(userId, null));
		if (user == null)
			return UriPath.HOME;
		User seuser = SessionUtil.getUser(session);
		if (seuser != null)
			if (seuser.getStringId().equals(userId))
				return "/myprofile/" + user.getStyle() + ".html";
		if (user.getStyle() == null)
			return UriPath.Profile.STYLE1;
		return "/profile/" + user.getStyle() + ".html";
	}
	
}
