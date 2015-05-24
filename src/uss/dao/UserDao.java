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

	
	public boolean insert(User user) {
		String sql = "INSERT INTO User values(null, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getStringId(), user.getPassword(), user.getEmail(), user.getName()) == 1;
	}

	public User find(User user) {
		SqlSupport ss = new SqlSupport();
		SqlParameter sp = ss.getSelectSql(user);
		return jdbcTemplate.queryForObject(sp.getSql(), new BeanPropertyRowMapper<User>(User.class), sp.getParameter());
	}

	public boolean update(User user) {
		String sql = "UPDATE User SET where stringId = ?";
		return false;
	}

	public List<User> findList(User user) {
		String sql = "";
		return null;
	}

}
