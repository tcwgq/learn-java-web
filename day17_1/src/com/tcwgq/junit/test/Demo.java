package com.tcwgq.junit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * Jdbc的CRUD
 * 
 * @author lenovo
 * 
 */
public class Demo {
	@Test
	public void insert() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "insert into stu values ('2222', '哈哈', 27, '男')";
		int row = st.executeUpdate(sql);
		System.out.println(row);
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
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "select * from stu";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			String no = rs.getString("no");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String gender = rs.getString("gender");
			System.out.println(no + "-" + name + "-" + age + "-" + gender);
		}
		rs.close();
		st.close();
		conn.close();
	}

	@Test
	public void update() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "update stu set age = 34 where name = 'lisi'";
		int row = st.executeUpdate(sql);
		System.out.println(row);
		st.close();
		conn.close();
	}

	@Test
	public void delete() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "delete from stu where name = '哈哈'";
		int row = st.executeUpdate(sql);
		System.out.println(row);
		st.close();
		conn.close();
	}

	@Test
	public void fun() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "select * from stu";
		// true或者false表示执行的结果是否有结果集
		if (st.execute(sql)) {
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				String no = rs.getString("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				System.out.println(no + "-" + name + "-" + age + "-" + gender);
			}
		} else {
			// delete, update, insert时需要获取影响的行
			int row = st.getUpdateCount();
			System.out.println(row);
		}
		st.close();
		conn.close();
	}

}
