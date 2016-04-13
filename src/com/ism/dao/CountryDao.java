package com.ism.dao;

import java.util.List;

import com.ism.entity.Country;

public interface CountryDao {
	
	public boolean save(Country country);

	public List<Country> findAll();

	public Country findById(int id);

	public List<Country> findByName(String name);

	public boolean update(Country country);

	public boolean delete(int idCountry);

	public int[] saveAll(List<Country> countries);

}
