package com.tcwgq.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.tcwgq.user.dao.UserDao;
import com.tcwgq.user.domain.User;
import com.tcwgq.utils.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao {

	@Override
	public User getUser(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs == null) {
				return null;
			}
			if (rs.next()) {
				user = new User(rs.getString("username"),
						rs.getString("password"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return user;
	}

	@Override
	public List<User> getUsers() {
		return null;
	}

	@Override
	public void save(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into user values (?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
