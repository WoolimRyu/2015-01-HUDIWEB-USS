package uss.controller;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import next.jdbc.mysql.DAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import uss.model.User;
import uss.response.Result;

public class UserControllerTest {

	@InjectMocks
	UserController controller;

	@Mock
	DAO dao;

	@Mock
	HttpSession session;

	@Before
	public void setup() throws NoSuchFieldException, SecurityException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void login() {
		assertEquals(Result.Login.getErrorPasswordNotMatched(), controller.login(null, session));
		assertEquals(Result.Login.getErrorUserNull(), controller.login(null, session));
		assertEquals(Result.getSuccess(), controller.login(null, session));
	}

	@Test
	public void update() {
		User sessionUser = new User("id", "pw");
		User updateUser = new User("id2", "pw1");
		Mockito.when(session.getAttribute(UserController.USER)).thenReturn(sessionUser);
		assertEquals(Result.getErrorBadRequest(), controller.update(updateUser, session));
		assertEquals(Result.getSuccess(), controller.update(sessionUser, session));
	}

	@Test
	public void register() {
		User user1 = new User("id", "pw");
		User user2 = new User("id2", "pw1");
		assertEquals(Result.getErrorBadRequest(), controller.register(user1));
		assertEquals(Result.getSuccess(), controller.register(user2));
	}

}
