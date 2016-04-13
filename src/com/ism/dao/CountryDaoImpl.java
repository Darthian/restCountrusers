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

import com.ism.entity.Country;
import com.ism.entity.CountryRowMapper;

@Component("countryDao")
public class CountryDaoImpl implements CountryDao {
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Country country) {
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(country);

		return jdbcTemplate.update("insert into COUNTRY (NAME, DEPARTMENT, CITY) values (:name, :department, :city)", paramMap) == 1;
	}

	@Override
	public List<Country> findAll() {
		return jdbcTemplate.query("select * from COUNTRY",
				new RowMapper<Country>() {

					@Override
					public Country mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Country country = new Country();
						country.setIdCountry(rs.getInt("idCountry"));
						country.setName(rs.getString("name"));
						country.setDepartment(rs.getString("department"));
						country.setCity(rs.getString("city"));
						return country;
					}
				});
	}

	@Override
	public Country findById(int id) {
		return jdbcTemplate.queryForObject(
				"select * from COUNTRY where idCOUNTRY=:id",
				new MapSqlParameterSource("idCOUNTRY", id), new CountryRowMapper());
	}

	@Override
	public List<Country> findByName(String name) {
		return jdbcTemplate.query(
				"select * from COUNTRY where NAME like :name", new MapSqlParameterSource("name", "%" + name + "%"), new CountryRowMapper());
	}

	@Override
	public boolean update(Country country) {
		return jdbcTemplate
				.update("update COUNTRY set NAME=:name, DEPARTMENT=:department where idCOUNTRY=:idCountry", new BeanPropertySqlParameterSource(country)) == 1;
	}

	@Override
	public boolean delete(int idCountry) {
		return jdbcTemplate.update("delete from COUNTRY where idCOUNTRY=:idCountry", new MapSqlParameterSource("idCOUNTRY", idCountry)) == 1;
	}

	@Override
	public int[] saveAll(List<Country> countries) {
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(countries.toArray());

		return jdbcTemplate.batchUpdate("insert into COUNTRY (idCOUNTRY, NAME, DEPARTMENT, CITY) values (:idCountry, :name, :department, :city)", batchArgs);
	}

}
