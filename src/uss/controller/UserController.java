package uss.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.dao.UserDao;
import uss.model.User;
import uss.response.Response;
import uss.response.Result;
import uss.response.user.LoginResult;

@Controller
public class UserController {

	private static final String USER = "user";

	@Autowired
	UserDao dao;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Response register(User user) {
		if (!dao.insert(user))
			return Result.ERROR_SQL_EXCUTE;
		return Result.SUCCESS(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response login(User user) {
		User findedUser = dao.find(user);
		if (findedUser == null)
			return LoginResult.ERROR_USER_NULL;
		if (!findedUser.getPassword().equals(user.getPassword()))
			return LoginResult.ERROR_PASSWORD_NOT_MATCHED;
		return Result.SUCCESS(findedUser);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public Response update(User user, HttpSession session) {
		User sessionUser = (User) session.getAttribute(USER);
		if (!sessionUser.getStringId().equals(user.getStringId()))
			return Result.ERROR_BAD_REQUEST;
		if (!dao.update(user))
			return Result.ERROR_SQL_EXCUTE;
		return Result.SUCCESS(user);
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public Response search(User user) {
		List<User> userList = dao.findList(user);
		if (userList == null)
			return Result.ERROR_SEARCH_NOT_FOUND;
		return Result.SUCCESS(userList);
	}

}
