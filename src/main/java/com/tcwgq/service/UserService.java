package com.tcwgq.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcwgq.dao.UserDao;
import com.tcwgq.model.User;

/**
 * @author tcwgq
 * @time 2017年8月27日上午10:30:07
 * @email tcwgq@outlook.com
 */
@Service
@Transactional
public class UserService {
	// 注解方式注入properties文件属性值
	@Value("#{prop.filePath}")
	private String filePath;

	@Resource
	private UserDao userDao;

	public void add(User user) {
		System.out.println(filePath);
		userDao.add(user);
	}

	public User get(int id) {
		return userDao.get(id);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
}
