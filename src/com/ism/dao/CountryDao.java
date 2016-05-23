package com.ism.dao;

import java.util.List;

import com.ism.entity.Country;

public interface CountryDao {
	
	public void save(Country country);

	public List<Country> findAll();

	public Country findById(int id);

	public List<Country> findByName(String name);

	public void update(Country country);

	public void delete(Country country);

//	public int[] saveAll(List<Country> countries);

}
