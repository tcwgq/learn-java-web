package com.tcwgq.dao;

import com.tcwgq.model.User;

/**
 * @author tcwgq
 * @time 2017年8月27日下午5:43:47
 * @email tcwgq@outlook.com
 */
public interface UserDao {

	public void add(User user);

	public User get(int id);

	public User getUserById(int id);
}
