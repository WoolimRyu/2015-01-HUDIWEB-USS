package uss.model.join;

import java.net.HttpURLConnection;

import next.jdbc.mysql.DAO;

import org.junit.Test;

import uss.model.Group;
import uss.model.GroupHasUser;
import uss.model.User;
import uss.util.HttpReq;

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
		System.out.println(HttpReq.excute("GET", "http://openapi.map.naver.com/api/geocode?key=8c0647eaaa13e3692462b2a8c7d2b1bc&encoding=utf-8&coord=latlng&output=json&query=%EA%B2%BD%EA%B8%B0%EB%8F%84%20%EC%84%B1%EB%82%A8%EC%8B%9C%20%EB%B6%84%EB%8B%B9%EA%B5%AC%20%EC%A0%95%EC%9E%90%EB%8F%99%20178-1",""));
		
		
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
