package uss.util;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uss.model.User;

public class SqlSupportTest {
	private static final Logger logger = LoggerFactory.getLogger(SqlSupportTest.class);

	private User user;
	private SqlSupport ss;
	
	@Before
	public void setUp() {
		user = new User("testId", "testPw");
		ss = new SqlSupport();
	}
	
	@Test
	public void testGetParameter() {
		Map<Field, Object> map = ss.getParameter(user);
		
		assertEquals(map.size(), 2);
		for (Field key : map.keySet()) {
			logger.debug("filed : {} value : {}", key.getName(), map.get(key));
		}
	}
	
	@Test
	public void testGetSelectSql() {
		SqlParameter sp = ss.getSelectSql(user);
		assertEquals("SELECT * FROM User WHERE stringId = ? and password = ?", sp.getSql());
	}
	
	@Test
	public void testGetUpdateSql() {
		SqlParameter sp = ss.getUpdateSql(user);
		assertEquals("UPDATE User SET password = ? WHERE stringId = ?", sp.getSql());
		
		User user2 = new User("user1", "1");
		user2.setEmail("email");
		user2.setName("name");
		
		SqlParameter sp2 = ss.getUpdateSql(user2);
		assertEquals("UPDATE User SET password = ?, email = ?, name = ? WHERE stringId = ?", sp2.getSql());
	}
	
	@Test
	public void testGetInsertSql() {
		SqlParameter sp = ss.getInsertSql(user);
		assertEquals("INSERT User SET stringId = ?, password = ?", sp.getSql());
		
		User user2 = new User("user1", "1");
		user2.setEmail("email");
		user2.setName("name");
		
		SqlParameter sp2 = ss.getInsertSql(user2);
		assertEquals("INSERT User SET stringId = ?, password = ?, email = ?, name = ?", sp2.getSql());
	}

}
