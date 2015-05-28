package uss.controller;

import java.util.List;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.model.Group;
import uss.response.Response;
import uss.response.Result;

@Controller
@RequestMapping("/api/group")
public class GroupConroller {

	@Autowired
	DAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public Response get(Group group) {
		Group g = dao.find(group);
		if (g == null)
			return Result.getErrorSearchNotFound();
		return Result.getSuccess(g);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Response insert(Group group) {
		if (!dao.insert(group))
			return Result.getErrorSqlExcute();
		return Result.getSuccess();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Response update(Group group) {
		if (!dao.update(group))
			return Result.getErrorSqlExcute();
		return Result.getSuccess();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getList(Group group) {
		List<Group> groupList = dao.findList(group);
		if (groupList == null)
			return Result.getErrorSearchNotFound();
		return Result.getSuccess(groupList);
	}
}
