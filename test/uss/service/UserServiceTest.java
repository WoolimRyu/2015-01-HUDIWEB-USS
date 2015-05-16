package uss.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Field;

import next.jdbc.mysql.DAO;

import org.junit.Before;
import org.junit.Test;

import uss.model.User;
import uss.model.result.Result;

public class UserServiceTest {

	UserService service;

	@Before
	public void setup() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		// PackageCreator.reset();
		service = new UserService();
		Field f = service.getClass().getDeclaredField("dao");
		f.setAccessible(true);
		f.set(service, new DAO());
	}

	@Test
	public void test() {
		assertFalse(service.register(new User(null, "test", "test", "test", 1, "test", "test", "test")).isError());
	}

	@Test
	public void loginTest() {
		assertEquals(Result.LOGIN_SUCCESS, service.login(new User(null, "test", "test", "test", 1, "test", "test", "test")).getResult());
		assertEquals(Result.LOGIN_NOT_EXIST_ID, service.login(new User(null, "test", "te2st", "test", 1, "test", "test", "test")).getResult());
		assertEquals(Result.LOGIN_PASSWORD_NOT_MATCHED, service.login(new User(null, "test", "test", "te2st", 1, "test", "test", "test")).getResult());
	}

	@Test
	public void registerTest() {
		assertEquals(Result.REGISTER_ALREADY_EXIST_ID, service.register(new User(null, "test", "test", "test", 1, "test", "test", "test")));
		assertEquals(Result.REGISTER_SUCCESS, service.register(new User(null, "test", "test2", "test", 1, "test", "test", "test")));
	}
}
