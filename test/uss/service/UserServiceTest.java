package uss.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uss.controller.UserController;
import uss.dao.UserDao;
import uss.model.User;
import uss.response.Result;
import uss.response.user.LoginResult;

public class UserServiceTest {

	
	UserController service;

	@Before
	public void setup() {
		UserDao dao = new UserDao();
		dao.insert(new User("test","1"));
	}

	@Test
	public void testLogin() {
		assertEquals(service.login(new User("test2", "1")), LoginResult.ERROR_USER_NULL);
		assertEquals(service.login(new User("test", "2")), LoginResult.ERROR_PASSWORD_NOT_MATCHED);
		assertEquals(service.login(new User("test", "1")), Result.SUCCESS(null));
	}
	

}
 