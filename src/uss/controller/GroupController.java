package uss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.dao.GroupDao;
import uss.model.Group;

@RequestMapping("/group")
public class GroupController {

	@Autowired
	GroupDao dao;

	@RequestMapping(method = RequestMethod.GET)
	public Group get(Group group) {
		return dao.find(group);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Group getList(Group group) {
		return dao.findList(group);
	}
}
