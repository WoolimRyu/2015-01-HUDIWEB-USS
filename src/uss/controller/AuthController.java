package uss.controller;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import uss.model.User;
import uss.response.Result;

public class AuthController {
	
	@Autowired
	DAO dao;
	
	@RequestMapping("/api/auth")
	public Object confirm(User user) {
		User findedUser = dao.find(user, "stringId");
		if (findedUser == null)
			return Result.getErrorSearchNotFound();
		if (!findedUser.getAuthcode().equals(user.getAuthcode()))
			return Result.getErrorBadRequest();
		user.setAuthcode("1");
		
		if (!dao.update(user))
			return Result.getErrorSqlExcute();
		return Result.getSuccess();
	}

}
