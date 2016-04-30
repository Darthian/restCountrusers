package com.ism.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ism.dao.CountryDao;

@Service
public class CountryService {

	@Autowired
	private CountryDao countryDao;
	
}
