package uss.dao;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uss.model.User;
import uss.util.SqlParameter;
import uss.util.SqlSupport;

@Repository
public class UserDao {

	// @Autowired
	private JdbcTemplate jdbcTemplate;
	private SqlSupport ss = new SqlSupport();
	
	public boolean insert(User user) {
		SqlParameter sp = ss.getInsertSql(user);
		return jdbcTemplate.update(sp.getSql(), sp.getParameter()) == 1;
	}

	public User find(User user) {
		SqlParameter sp = ss.getSelectSql(user);
		return jdbcTemplate.queryForObject(sp.getSql(), new BeanPropertyRowMapper<User>(User.class), sp.getParameter());
	}

	public boolean update(User user) {
		SqlParameter sp = ss.getUpdateSql(user);
		return jdbcTemplate.update(sp.getSql(), sp.getParameter()) == 1;
	}

	public List<User> findList(User user) {
		SqlParameter sp = ss.getSelectSql(user);
		return jdbcTemplate.query(sp.getSql(), new BeanPropertyRowMapper<User>(User.class), sp.getParameter());
	}

}
