package com.tcwgq.bookstore.user.junit.test;

import org.junit.Test;

import com.tcwgq.bookstore.user.dao.UserDao;
import com.tcwgq.bookstore.user.domain.User;

public class UserDaoTest {
	private UserDao dao = new UserDao();

	@Test
	public void testFindByUsername() {
		User user = dao.findByUsername("zhangSan");
		System.out.println(user);
	}

	@Test
	public void testFindByEmail() {
		User user = dao.findByEmail("770100361@qq.com");
		System.out.println(user);
	}

	@Test
	public void testAdd() {
	}

}
