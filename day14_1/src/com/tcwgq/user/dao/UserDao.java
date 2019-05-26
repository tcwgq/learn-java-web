package com.tcwgq.user.dao;

import java.util.List;

import com.tcwgq.user.domain.User;

public interface UserDao {
	public User getUser(String username);

	public List<User> getUsers();

	public void save(User user);
}
