package uss.controller;

import java.lang.reflect.Field;


import next.jdbc.mysql.DAO;

import org.junit.Before;
import org.junit.Test;

public class SearchControllerTest {

	SearchController controller;

	DAO dao;

	@Before
	public void setup() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		controller = new SearchController();
		Field field = controller.getClass().getDeclaredField("dao");
		field.setAccessible(true);
		dao = new DAO();
		field.set(controller, dao);
	}

	@Test
	public void test() {
		System.out.println(controller.search("test", null));
	}
}
