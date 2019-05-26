package com.tcwgq.bookstore.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.tcwgq.bookstore.user.domain.User;

import cn.itcast.jdbc.TxQueryRunner;

public class UserDao {
	private QueryRunner qr = new TxQueryRunner();

	public User findByUsername(String username) {
		String sql = "select * from user where username = ?";
		try {
			User user = qr.query(sql, new BeanHandler<User>(User.class),
					username);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findByEmail(String email) {
		String sql = "select * from user where email = ?";
		try {
			User user = qr.query(sql, new BeanHandler<User>(User.class), email);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void add(User user) {
		String sql = "insert into user values(?, ?, ?, ?, ?, ?)";
		Object[] params = { user.getUid(), user.getUsername(),
				user.getPassword(), user.getEmail(), user.getCode(),
				user.isState() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User findByCode(String code) {
		String sql = "select * from user where code = ?";
		try {
			User user = qr.query(sql, new BeanHandler<User>(User.class), code);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateState(String uid, boolean state) {
		String sql = "update user set state = ? where uid = ?";
		try {
			qr.update(sql, state, uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
