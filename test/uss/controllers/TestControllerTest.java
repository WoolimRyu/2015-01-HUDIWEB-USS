package uss.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uss.model.User;

public class TestControllerTest {

	@Test
	public void test() {
		Object user = new User(null);
		System.out.println(user.getClass());
	}
}
