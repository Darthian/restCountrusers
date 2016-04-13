package com.ism.dao;

import java.util.List;

import com.ism.entity.User;

public interface UserDao {

	public boolean save(User user);

	public List<User> findAll();

	public User findById(int id);

	public List<User> findByName(String name);

	public boolean update(User user);

	public boolean delete(int idUser);

	public int[] saveAll(List<User> users);

}
