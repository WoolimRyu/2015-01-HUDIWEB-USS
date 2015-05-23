package uss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import uss.dao.UserDao;
import uss.model.User;
import uss.response.Response;
import uss.response.Result;
import uss.response.user.LoginResult;

@Service
public class UserService {

	UserDao dao;

	public Response register(User user) {
		if (!dao.insert(user))
			return Result.ERROR_SQL_EXCUTE;
		return Result.SUCCESS(user);
	}

	public Response login(User user) {
		User findedUser = dao.find(user);
		if (findedUser == null)
			return LoginResult.ERROR_USER_NULL;
		if (!findedUser.getPassword().equals(user.getPassword()))
			return LoginResult.ERROR_PASSWORD_NOT_MATCHED;
		return Result.SUCCESS(findedUser);
	}

	public Response update(User user, User loginUser) {
		if (!loginUser.getStringId().equals(user.getStringId()))
			return Result.ERROR_BAD_REQUEST;

		if (!dao.update(user))
			return Result.ERROR_SQL_EXCUTE;

		return Result.SUCCESS(user);
	}

	public Response search(User user) {
		List<User> userList = dao.findList(user);
		if (userList == null)
			return Result.ERROR_USER_NOT_FOUND;
		return Result.SUCCESS(userList);
	}

}
