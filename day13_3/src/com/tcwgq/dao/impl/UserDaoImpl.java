package com.tcwgq.dao.impl;

import com.tcwgq.dao.UserDao;
import com.tcwgq.domain.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUser() {
		return new User("zhangSan", "123");
	}

}
