package com.tcwgq.junit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.tcwgq.utils.JdbcUtils;

/**
 * 代码规范化
 * 
 * @author lenovo
 * 
 */
public class Demo2 {
	@Test
	public void insert() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "insert into stu values ('2222', '哈哈', 27, '男')";
		int row = st.executeUpdate(sql);
		System.out.println(row);
		JdbcUtils.free(null, st, conn);
		st.close();
		conn.close();
	}

	@Test
	public void select() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "select * from stu";
		System.out.println(st.execute(sql));
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			String no = rs.getString("no");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String gender = rs.getString("gender");
			System.out.println(no + "-" + name + "-" + age + "-" + gender);
		}
		JdbcUtils.free(rs, st, conn);
	}

	@Test
	public void update() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "update stu set age = 34 where name = 'lisi'";
		int row = st.executeUpdate(sql);
		System.out.println(row);
		JdbcUtils.free(null, st, conn);
	}

	@Test
	public void delete() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "delete from stu where name = '哈哈'";
		int row = st.executeUpdate(sql);
		System.out.println(row);
		JdbcUtils.free(null, st, conn);
	}

}
