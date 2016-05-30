package com.ism.dao;

import java.util.List;

import com.ism.entity.Country;
import com.ism.entity.User;

public interface UserDao {

	public void save(User user);

	public List<User> findAll(Country country);

	public User findById(int id);

	public List<User> findByName(String name);

	public void update(User user);

	public void delete(User user);

//	public int[] saveAll(List<User> users);

}
