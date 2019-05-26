package com.tcwgq.pool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * 使用dbcp连接池
 * 
 * @author lenovo
 * 
 */
public class Demo {
	@Test
	public void fun() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb4");
		dataSource.setUsername("root");
		dataSource.setPassword("112113");
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(3);
		dataSource.setMaxWait(1000);
		Connection conn = dataSource.getConnection();
		Connection conn1 = new MyConnection(conn);
		System.out.println(conn.getClass().getName());
		// 把连接归还给池，而不是真正的关闭连接
		conn1.close();
	}
}
