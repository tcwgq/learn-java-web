package com.tcwgq.service;

import com.tcwgq.dao.UserDao;
import com.tcwgq.dao.impl.UserDaoImpl;
import com.tcwgq.domain.User;

public class UserService {
	private UserDao userDao = new UserDaoImpl();

	public User findUser() {
		return userDao.getUser();
	}
}
