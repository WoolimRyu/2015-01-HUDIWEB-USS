package uss.service;


import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;

import uss.model.User;
import uss.result.Result;

public class RelationService {

	@Autowired
	private DAO dao;

	public Result addRelation(User user, String addUserId) {
		return null;
	}

	public Result getRelation(User user) {
		return null;
	}

	public Result deleteRelation(User user, String deleteUserId) {
		return null;
	}
}
