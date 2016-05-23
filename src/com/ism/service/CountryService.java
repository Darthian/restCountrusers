package com.ism.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ism.dao.CountryDao;
import com.ism.entity.Country;

@Service
public class CountryService {

	@Autowired
	private CountryDao countryDao;

	public void save(Country country) {
		countryDao.save(country);
	}

	public List<Country> findAll() {
		return countryDao.findAll();
	}

	public Country findById(int id) {
		return countryDao.findById(id);
	}

	public void saveOrUpdate(Country country) {
		
		System.out.println("idCountry: "+country.getIdCountry());
		if (country.getIdCountry() == 0) {
			System.out.println("Se CREA el pais");
			countryDao.save(country);
		} else {
			System.out.println("Se ACTUALZIA el pais");
			countryDao.update(country);
		}
		
	}

	public void delete(int id) {
		Country country = countryDao.findById(id);
		countryDao.delete(country);
	}
}