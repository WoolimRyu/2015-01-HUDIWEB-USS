package uss.service;

import static org.junit.Assert.fail;
import next.database.DAO;

import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

	UserService service;

	@Before
	public void setup() {
		service = new UserService(new DAO());
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
