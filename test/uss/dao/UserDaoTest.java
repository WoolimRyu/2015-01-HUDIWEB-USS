package uss.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uss.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml", "file:webapp/WEB-INF/uss-servlet.xml"})
public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Autowired
	private UserDao userDao;
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void insert() {
		User user = new User("userId1", "password", "email", "name");
		userDao.insert(user);
		logger.debug("insert user : {}", user);
		assertEquals(userDao.find(user), user);
	}
	
	@Test
	public void update() {
		User user = new User("userId1", "password2", "email2", "name2");
		userDao.update(user);
		assertEquals(userDao.find(user), user);
	}
	
	@Test
	public void findList() {
		User user = new User();
		user.setName("name");
		List<User> list = userDao.findList(user);
		logger.debug("list: {}", list.toString());
	}
}
