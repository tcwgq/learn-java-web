package com.tcwgq.junit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import com.tcwgq.utils.JdbcUtils;

/**
 * 获取元数据信息
 * 
 * @author lenovo
 * 
 */
public class Demo3 {
	@Test
	public void fun() throws ClassNotFoundException, SQLException {
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb4";
		String username = "root";
		String password = "112113";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "select * from stu";
		ResultSet rs = st.executeQuery(sql);
		int count = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= count; i++) {
				System.out.print(rs.getObject(i));
				if (i != count) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		JdbcUtils.free(null, st, conn);
	}
}
