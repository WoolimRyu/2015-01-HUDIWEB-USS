package uss.service;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;

import uss.model.User;
import uss.result.Result;
import uss.result.ResultWithObject;

public class UserService {

	@Autowired
	private DAO dao;

	public Result register(User user) {
		if (null != dao.fill(new User(user.getEmail())))
			return Result.REGISTER_ALREADY_EXIST_ID;
		dao.insert(user);
		return Result.REGISTER_SUCCESS;
	}

	public ResultWithObject login(User user) {
		User fromDB = dao.fill(new User(user.getEmail()));
		if (fromDB == null) {
			return new ResultWithObject(Result.LOGIN_NOT_EXIST_ID, fromDB);
		}
		if (!fromDB.getPassword().equals(user.getPassword())) {
			return new ResultWithObject(Result.LOGIN_PASSWORD_NOT_MATCHED, null);
		}
		return new ResultWithObject(Result.LOGIN_SUCCESS, fromDB);
	}

	public Result update(User updatedUser, User session) {
		return null;
	}
}
