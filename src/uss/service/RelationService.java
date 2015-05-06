package uss.service;

import org.springframework.beans.factory.annotation.Autowired;

import uss.dao.RelationDao;
import uss.model.User;
import uss.model.response.Response;

public class RelationService {

	@Autowired
	RelationDao dao;

	public Response addRelation(User user, String addUserId) {
		return null;
	}

	public Response getRelation(User user) {
		return null;
	}

	public Response deleteRelation(User user, String deleteUserId) {
		return null;
	}
}
