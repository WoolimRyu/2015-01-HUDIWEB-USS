package uss.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.model.User;
import uss.response.Response;
import uss.response.Result;
import uss.util.SessionUtil;

@RestController
@RequestMapping("/api")
public class UserController {

	static final String USER = "user";

	@Autowired
	DAO dao;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Response get(User user) {
		User found = dao.find(user);
		if (found == null)
			return Result.getErrorSqlExcute();
		return Result.getSuccess(found);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Response register(User user) {
		if (!dao.insert(user))
			return Result.getErrorSqlExcute();
		return Result.getSuccess(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response login(User user, HttpSession session) {
		User findedUser = dao.find(user);
		if (findedUser == null)
			return Result.Login.getErrorUserNull();
		if (!findedUser.getPassword().equals(user.getPassword()))
			return Result.Login.getErrorPasswordNotMatched();
		session.setAttribute(USER, findedUser);
		System.out.println(session.getAttribute(USER));
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

}
