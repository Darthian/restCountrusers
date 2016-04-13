package com.ism.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ism.entity.User;
import com.ism.entity.UserRowMapper;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean save(User user) {
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(user);

		return jdbcTemplate.update("insert into USER (NAME, PASSWORD) values (:name, :password)", paramMap) == 1;
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("select * from USER",
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();

						user.setIdUser(rs.getInt("idUser"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));

						return user;
					}
				});
	}

	@Override
	public User findById(int id) {
		return jdbcTemplate.queryForObject(
				"select * from USER where idUSER=:id",
				new MapSqlParameterSource("idUSER", id), new UserRowMapper());
	}

	@Override
	public List<User> findByName(String name) {
		return jdbcTemplate.query(
				"select * from USER where NAME like :name", new MapSqlParameterSource("name", "%" + name + "%"), new UserRowMapper());
	}

	@Override
	public boolean update(User user) {
		return jdbcTemplate
				.update("update USER set NAME=:name, PASSWORD=:password where idUSER=:idUSER", new BeanPropertySqlParameterSource(user)) == 1;
	}

	@Override
	public boolean delete(int idUser) {
		return jdbcTemplate.update("delete from USER where idUSER=:idUser", new MapSqlParameterSource("idUser", idUser)) == 1;
	}

	@Transactional
	@Override
	public int[] saveAll(List<User> users) {
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(users.toArray());

		return jdbcTemplate.batchUpdate("insert into USER (idUSER, NAME, PASSWORD) values (:idUser, :name, :password)", batchArgs);
	}

}
