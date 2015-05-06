package uss.service;


import org.springframework.beans.factory.annotation.Autowired;

import uss.dao.UserDao;
import uss.model.User;
import uss.model.response.Response;

public class UserService {
	@Autowired
	private UserDao dao;

	public Response register(User user) {
		if (null != dao.find(user.getStringId()))
			return new Response(true, "이미 존재하는 아이디입니다.");
		dao.insert(user);
		return new Response(user);
	}

	public Response login(User user) {
		User fromDB = dao.find(user.getStringId());
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
