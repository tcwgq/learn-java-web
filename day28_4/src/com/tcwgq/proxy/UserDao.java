package com.tcwgq.proxy;

import java.util.List;

public interface UserDao {
	public void add(User user);

	public List<User> findAll();

	public User findById(int id);
}
