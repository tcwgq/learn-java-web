package com.tcwgq.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 模拟用户转账，使用jdbc事务
 * 
 * @author lenovo
 * 
 */
public class AccountDao {
	public void update(Connection conn, String name, double money) {
		String sql = "update account set balance = balance + ? where name = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, money);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
