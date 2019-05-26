package com.tcwgq.bookstore.user.service;

import com.tcwgq.bookstore.user.dao.UserDao;
import com.tcwgq.bookstore.user.domain.User;
import com.tcwgq.bookstore.user.exception.UserException;

public class UserService {
	private UserDao dao = new UserDao();

	public void regist(User form) throws UserException {
		User user = dao.findByUsername(form.getUsername());
		if (user != null) {
			throw new UserException("用户名已被注册!");
		}
		user = dao.findByEmail(form.getEmail());
		if (user != null) {
			throw new UserException("邮箱已被注册!");
		}
		dao.add(form);
	}

	public void active(String code) throws UserException {
		User user = dao.findByCode(code);
		if (user == null) {
			throw new UserException("激活码无效");
		}
		if (user.isState()) {
			throw new UserException("你的账号已经激活，不能重复激活！");
		}
		dao.updateState(user.getUid(), true);
	}

	public User login(User form) throws UserException {
		User user = dao.findByUsername(form.getUsername());
		if (user == null) {
			throw new UserException("用户不存在！");
		}
		if (!form.getPassword().equals(user.getPassword())) {
			throw new UserException("密码错误！");
		}
		if (!user.isState()) {
			throw new UserException("账号尚未激活，请先激活再登陆！");
		}
		return user;
	}
}
