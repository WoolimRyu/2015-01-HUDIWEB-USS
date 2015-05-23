package uss.dao;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uss.model.User;

@Repository
public class UserDao {
	
//	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(User user) {
		String sql = "insert into USER values(?, ?, ?, ?, ? ,now(), null, 'F', ?)";
		return jdbcTemplate.update(sql, user.getId(), user.getPassword(), user.getName())==1;
	}

//
//	public void updateCustomer(final User user) {
//		String sql = "update USER set PHONE = ?, ADDRESS = ? where ID = ?";
//		jdbcTemplate.update(sql, user.getPhone(), user.getAddress(), user.getId());
//	}
//
//
//	public User selectUserById(final String userId) {
//		String sql = "select * from USER where ID=?";
//		try {
//			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), userId);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}


	public User find(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> findList(User user) {
		// TODO Auto-generated method stub
		return null;
	}




}
