package uss.model.join;

import java.net.HttpURLConnection;

import next.jdbc.mysql.DAO;

import org.junit.Test;

import uss.model.Group;
import uss.model.User;
import uss.util.HttpReq;

public class UsersGroupTest {

	@Test
	public void test() {
		Group g = new Group();
		g.setUserId(1);
		User user = new User();
		user.setUserId(1);
		DAO dao = new DAO();
	}

	@Test
	public void testss() {
		System.out.println("wear@awer.com".matches("\\w+@\\w+\\.\\w+"));
	}

	@Test
	public void tests() {
		Group g = new Group();
		g.setUserId(1);
		DAO dao = new DAO();
		User user = new User();
		user.setUserId(1);
		dao.update(user);
	}

}
