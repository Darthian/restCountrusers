package com.ism.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountryRowMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		country.setIdCountry(rs.getInt("idCountry"));
		country.setName(rs.getString("name"));
		country.setDepartment(rs.getString("department"));
		country.setCity(rs.getString("city"));
		return country;
	}

}
