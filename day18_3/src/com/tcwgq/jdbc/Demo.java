package com.tcwgq.jdbc;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用c3p0数据库连接池
 * 
 * @author lenovo
 * 
 */
public class Demo {
	@Test
	public void fun1() throws PropertyVetoException, SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb4");
		dataSource.setUser("root");
		dataSource.setPassword("112113");

		dataSource.setAcquireIncrement(5);
		dataSource.setMaxPoolSize(20);
		dataSource.setMinPoolSize(3);
		Connection conn = dataSource.getConnection();
		System.out.println(conn.getClass().getName());
		conn.close();
	}

	@Test
	public void fun2() throws PropertyVetoException, SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = dataSource.getConnection();
		System.out.println(conn.getClass().getName());
		conn.close();
	}

	@Test
	public void fun3() throws PropertyVetoException, SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource(
				"oracle-config");
		Connection conn = dataSource.getConnection();
		System.out.println(conn.getClass().getName());
		conn.close();
	}
}
