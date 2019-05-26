package com.tcwgq.user.service;

import com.tcwgq.user.dao.UserDao;
import com.tcwgq.user.domain.User;
import com.tcwgq.user.factory.daoFactory;

public class UserService {
	private UserDao userDao = daoFactory.getUserDao();

	public void regist(User user) throws userException {
		User _user = userDao.getUser(user.getUsername());
		if (_user != null)
			throw new userException("用户名" + user.getUsername() + "已被使用");
		userDao.save(user);
	}

	public User login(User form) throws userException {
		User user = userDao.getUser(form.getUsername());
		if (user == null)
			throw new userException("用户名不存在！");
		if (!user.getPassword().equals(form.getPassword())) {
			throw new userException("密码错误！");
		}
		return user;
	}
}
