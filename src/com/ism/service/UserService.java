package com.ism.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ism.dao.CountryDao;
import com.ism.dao.UserDao;
import com.ism.entity.Country;
import com.ism.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CountryDao countryDao;

	public void save(User user, Country country) {
		user.setCountry(country);
		userDao.save(user);
	}

	public List<User> findAll(int idCountry) {
		List<User> result = new ArrayList<User>();
		Country country = countryDao.findById(idCountry);
		result = userDao.findAll(country);
		return result;
	}

	public User findById(int idUser) {
		User result = new User();
		result = userDao.findById(idUser);
		return result;
	}

	public void saveOrUpdate(User user) {
		if (user.getIdUser() == 0) {
			System.out.println("Se CREA el usuario");
			userDao.save(user);
		} else {
			System.out.println("Se ACTUALIZA el usuario");
			userDao.update(user);
		}
	}

	public void delete(int idUser) {
		User user = userDao.findById(idUser);
		userDao.delete(user);
	}
}
