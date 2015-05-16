package uss.service;

import next.database.DAO;

import org.springframework.beans.factory.annotation.Autowired;

import uss.model.User;
import uss.model.response.Response;

public class UserService {

	public UserService() {
	}

	public UserService(DAO dao) {
		this.dao = dao;
	}

	@Autowired
	private DAO dao;

	public Response register(User user) {
		if (null != dao.find(User.class, user.getId()))
			return new Response(true, "이미 존재하는 아이디입니다.");
		dao.insert(user);
		return new Response(user);
	}

	public Response login(User user) {
		User fromDB = dao.find(User.class, user.getId());
		if (fromDB == null) {
			return new Response(true, "없는 아이디입니다.");
		}
		if (!fromDB.getPassword().equals(user.getPassword())) {
			return new Response(true, "패스워드가 다릅니다.");
		}
		return new Response(fromDB);
	}

	public Response update(User updatedUser, User session) {
		return null;
	}
}
