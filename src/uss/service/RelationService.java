package uss.service;

import next.database.DAO;

import org.springframework.beans.factory.annotation.Autowired;

import uss.model.User;
import uss.model.response.Response;

public class RelationService {

	@Autowired
	private DAO dao;

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
