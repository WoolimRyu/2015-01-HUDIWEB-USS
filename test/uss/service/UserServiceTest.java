package uss.service;

import static org.junit.Assert.assertFalse;
import next.jdbc.mysql.DAO;

import org.junit.Before;
import org.junit.Test;

import uss.model.User;

public class UserServiceTest {

	UserService service;

	@Before
	public void setup() {
		service = new UserService(new DAO());
	}

	@Test
	public void test() {
		assertFalse(service.register(new User(null, "test", "test", "test", 1, "test", "test", "test")).isError());
	}

	@Test
	public void login() {
		// case Success
		assertFalse(service.login(new User(null, "test", "test", "test", 1, "test", "test", "test")).getResult().isError());
		// assertTrue(service.login(new User(null, "test", "test", "test", 1,
		// "test", "test", "test")).getResult().isError());
		// case password wrong
	}

}
