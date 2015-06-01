package uss.controller.util;

import javax.servlet.http.HttpSession;

import next.jdbc.mysql.DAO;
import next.jdbc.mysql.maker.PackageCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.constants.UriPath;
import uss.launcher.DBLauncher;
import uss.model.User;
import uss.model.cards.Card;
import uss.util.SessionUtil;
import uss.util.exception.SessionNullException;

@Controller
public class Dispacher {

	@Autowired
	DAO dao;
	
	
	@RequestMapping(value = "/api/logout", method = RequestMethod.GET)
	public String logout(User user, HttpSession session) {
		SessionUtil.logout(session);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/api/serverstart", method = RequestMethod.GET)
	public String ser() {
		PackageCreator.reset();
		DBLauncher.insertTestData();
		return "ok";
	}


	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String search(@PathVariable String userId, HttpSession session) {
		User user = dao.find(new User(userId, null));
		if (user == null)
			return UriPath.HOME;
		Card card = new Card(user.getRepresentiveCardId());
		card = dao.find(card);
		if (card == null)
			return UriPath.HOME;
		User seuser = SessionUtil.getUser(session);
		if (seuser != null) {
			if (seuser.getStringId().equals(userId))
				return "/myprofile/t" + card.getTemplate() + ".html";
		}
		return "/profile/t" + card.getTemplate() + ".html";
	}

	@RequestMapping(value = "/home/dispatch", method = RequestMethod.GET)
	public String dispatch(HttpSession session) {
		User user = SessionUtil.getUser(session);
		if (user == null)
			return "redirect:main/";
		if(user.getRepresentiveCardId() == null || user.getRepresentiveCardId().equals(0))
			return "redirect:myprofile/first/";
		return "redirect:myprofile/mylist/";
	}

	@ExceptionHandler(SessionNullException.class)
	public String handle1(SessionNullException e) {
		return "redirect:home/login.html";
	}

}
