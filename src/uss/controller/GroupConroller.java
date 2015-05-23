package uss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.dao.GroupDao;
import uss.model.Group;
import uss.response.Response;
import uss.response.Result;

@RequestMapping("/group")
public class GroupConroller {

	@Autowired
	GroupDao dao;

	@RequestMapping(method = RequestMethod.GET)
	public Response get(Group group) {
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Response insert(Group group) {
		if(!dao.insert(group))
			return Result.ERROR_SQL_EXCUTE;
		return Result.SUCCESS;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Response update(Group group) {
		if(!dao.update(group))
			return Result.ERROR_SQL_EXCUTE;
		return Result.SUCCESS;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getList(Group group) {
		List<Group> groupList = dao.findList(group);
		if (groupList == null)
			return Result.ERROR_SEARCH_NOT_FOUND;
		return Result.SUCCESS(groupList);
	}
}
