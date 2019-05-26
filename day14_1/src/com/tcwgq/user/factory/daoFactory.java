package com.tcwgq.user.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.tcwgq.user.dao.UserDao;

public class daoFactory {
	private static Properties props = null;
	static {
		InputStream is = daoFactory.class.getClassLoader().getResourceAsStream(
				"dao.properties");
		props = new Properties();
		try {
			props.load(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static UserDao getUserDao() {
		UserDao userDao = null;
		try {
			Class clazz = Class.forName(props.getProperty("daoClass"));
			userDao = (UserDao) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return userDao;
	}
}
