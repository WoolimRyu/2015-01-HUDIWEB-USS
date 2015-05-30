package uss.model.join;

import next.jdbc.mysql.DAO;

import org.junit.Test;

import uss.model.Group;
import uss.model.GroupHasUser;
import uss.model.User;

public class UsersGroupTest {

	@Test
	public void test() {
		Group g = new Group();
		g.setUserId(1);
		User user = new User();
		user.setUserId(1);
		UsersGroup usersGroup = new UsersGroup(new Group(), new GroupUser(new GroupHasUser(null, null), user));
		DAO dao = new DAO();
		System.out.println(dao.findList(usersGroup));
	}

	@Test
	public void testss() {
		System.out.println("pass1@tea.com".matches("@"));
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
