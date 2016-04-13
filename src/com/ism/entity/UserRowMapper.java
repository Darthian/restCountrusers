package com.ism.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setIdUser(rs.getInt("idUser"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
