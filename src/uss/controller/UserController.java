package uss.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.mail.AuthMail;
import uss.mail.EmailSender;
import uss.model.User;
import uss.model.cards.Card;
import uss.response.Response;
import uss.response.Result;
import uss.util.SessionUtil;

@RestController
@RequestMapping("/api")
public class UserController {

	static final String USER = "user";

	@Autowired
	DAO dao;
	
	@Autowired
	private EmailSender emailSender;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Response get(User user) {
		User found = dao.find(user);
		if (found == null)
			return Result.getErrorSqlExcute();
		return Result.getSuccess(found);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Response register(User user) throws MessagingException {
		if (!dao.insert(user))
			return Result.getErrorSqlExcute();
		emailSender.sendEmail(new AuthMail(user));
		return Result.getSuccess(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(User user, HttpSession session) {
		String password = user.getPassword();
		User findedUser = dao.find(user, "stringId");
		if (findedUser == null)
			return Result.Login.getErrorUserNull();
		if (!findedUser.getPassword().equals(password))
			return Result.Login.getErrorPasswordNotMatched();
		session.setAttribute(USER, findedUser);
		return Result.getSuccess(findedUser);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public Response update(@ModelAttribute User usersended, HttpSession session) {
		System.out.println(usersended);
		User user = SessionUtil.getUser(session);
		user.update(usersended);
		if (!dao.update(user))
			return Result.getErrorSqlExcute();
		return Result.getSuccess(user);
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public Response search(User user) {
		List<User> userList = dao.findList(user);
		if (userList == null)
			return Result.getErrorSearchNotFound();
		return Result.getSuccess(userList);
	}

	@RequestMapping(value = "/user/getRepresentiveCard")
	public Response getCard(User user) {
		User userfind = dao.find(user);
		if (userfind == null)
			return null;
		Card card = new Card();
		card.setCardId(userfind.getRepresentiveCardId());
		return Result.getSuccess(dao.find(card));
	}

}
