package uss.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.model.Group;
import uss.model.GroupHasUser;
import uss.model.User;
import uss.model.join.GroupUser;
import uss.model.join.UsersGroup;
import uss.response.Response;
import uss.response.Result;

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
		return Result.getSuccess(findedUser);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public Response update(User user, HttpSession session) {
		User sessionUser = (User) session.getAttribute(USER);
		if (!sessionUser.getStringId().equals(user.getStringId()))
			return Result.getErrorBadRequest();
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

	@RequestMapping(value = "/friend/list", method = RequestMethod.GET)
	public Response findFriends(HttpSession session) {
		User user = (User) session.getAttribute(USER);
		UsersGroup usersGroup = new UsersGroup(new Group(), new GroupUser(new GroupHasUser(null, null), user));
		List<UsersGroup> userList = dao.findList(usersGroup);
		if (userList == null)
			return Result.getErrorSearchNotFound();
		return Result.getSuccess(userList);
	}
}
