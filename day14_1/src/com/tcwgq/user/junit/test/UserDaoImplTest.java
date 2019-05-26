package com.tcwgq.user.junit.test;

import java.util.List;

import org.junit.Test;

import com.tcwgq.user.dao.UserDao;
import com.tcwgq.user.dao.impl.UserDaoImpl;
import com.tcwgq.user.domain.User;

public class UserDaoImplTest {
	private UserDao userDao = new UserDaoImpl();

	@Test
	public void testSave() {
		// 探讨一下输出流如何将文件写到项目下的指定目录中
		for (int i = 1; i <= 10; i++) {
			User user = new User("name_" + i, "123" + i);
			System.out.println(user);
			userDao.save(user);
		}
	}

	@Test
	public void testGetUser() {
		User user = userDao.getUser("张三");
		System.out.println(user);
	}

	@Test
	public void testGetUsers() {
		List<User> users = userDao.getUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
