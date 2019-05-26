package com.tcwgq.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.tcwgq.utils.JdbcUtils;

/**
 * 模拟用户转账，体会事务的使用
 * 
 * @author lenovo
 * 
 */
public class UserService {
	public void transfer(String from, String to, double money) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			AccountDao dao = new AccountDao();
			dao.update(conn, "张三", -money);
			if (true) {
				throw new RuntimeException("不好意思，出错了");
			}
			dao.update(conn, "李四", money);
			conn.commit();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		}
	}
}
