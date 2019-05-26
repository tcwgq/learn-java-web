package com.tcwgq.junit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.tcwgq.utils.JdbcUtils;

/**
 * PreparedStatement的用法与SQL注入
 * 
 * @author lenovo
 * 
 */
public class Demo4 {
	@Test
	public void fun() throws SQLException, ClassNotFoundException {
		String username = "a' or 'a' ='a";
		String password = "a' or 'a' ='a";
		System.out.println(login(username, password));
		System.out.println(login2(username, password));
	}

	/**
	 * sql攻击
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean login(String username, String password) throws SQLException,
			ClassNotFoundException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String user = "root";
		String pwd = "112113";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, user, pwd);
		Statement st = conn.createStatement();
		String sql = "select * from user where username = '" + username
				+ "' and password = '" + password + "'";
		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		boolean result = rs.next();
		JdbcUtils.free(rs, st, conn);
		return result;
	}

	public boolean login2(String username, String password)
			throws SQLException, ClassNotFoundException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4?useServerPrepStmts=true&cachePrepStmts=true";
		String user = "root";
		String pwd = "112113";
		String sql = "select * from user where username = ? and password = ?";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, user, pwd);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		System.out.println(sql);
		ResultSet rs = ps.executeQuery();
		boolean result = rs.next();
		JdbcUtils.free(rs, ps, conn);
		return result;
	}

}
