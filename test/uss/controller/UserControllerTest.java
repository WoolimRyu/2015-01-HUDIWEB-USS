package uss.controller;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import next.jdbc.mysql.maker.PackageCreator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uss.launcher.DBLauncher;
import uss.model.User;
import uss.response.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class UserControllerTest {

	@Autowired
	UserController controller;

	@Mock
	HttpSession session;

	@BeforeClass
	public static void setup() {
		PackageCreator.reset();
		DBLauncher.insertTestData();
	}

	@Before
	public void init() throws NoSuchFieldException, SecurityException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void registerTest() {
		User user = new User("test", "pass1");
		assertEquals(Result.SUCCESS(user), controller.register(user));
		assertEquals(Result.ERROR_SQL_EXCUTE, controller.register(user));
	}

	@Test
	public void loginTest() {
		User user = new User("id", "pw");
		controller.register(user);
		assertEquals(Result.Login.ERROR_PASSWORD_NOT_MATCHED, controller.login(new User("id", "pw2"), session));
		assertEquals(Result.Login.ERROR_USER_NULL, controller.login(new User("id3", "pw"), session));
		assertEquals(Result.SUCCESS(user), controller.login(user, session));
	}

	@Test
	public void updateTest() {
		User user = new User("id", "pw");
		user.setUserId(6);
		Mockito.when(session.getAttribute(UserController.USER)).thenReturn(user);
		User updateUser = new User("id2", "pw1");
		assertEquals(Result.ERROR_BAD_REQUEST, controller.update(updateUser, session));
		assertEquals(Result.SUCCESS(user), controller.update(user, session));
	}

}
