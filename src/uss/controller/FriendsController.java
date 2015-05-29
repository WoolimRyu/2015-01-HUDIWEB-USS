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

@RequestMapping("/api/friend")
@RestController
public class FriendsController {

	@Autowired
	DAO dao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response findFriends(HttpSession session) {
		User user = (User) session.getAttribute("user");
		UsersGroup usersGroup = new UsersGroup(new Group(), new GroupUser(new GroupHasUser(null, null), user));
		List<UsersGroup> userList = dao.findList(usersGroup);
		if (userList == null)
			return Result.getErrorSearchNotFound();
		return Result.getSuccess(userList);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addFriends(HttpSession session, GroupHasUser group) {
		User user = (User) session.getAttribute("user");
		if(!group.getUserId().equals(user.getUserId()))
			return Result.getErrorBadRequest();
		if (dao.insert(group))
			return Result.getErrorSqlExcute();
		return Result.getSuccess();
	}

}
