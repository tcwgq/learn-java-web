package com.tcwgq.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JdbcUtils1.0
 * 
 * @author lenovo
 * 
 */
public class JdbcUtils1 {
	public static Connection getConnection() throws Exception {
		InputStream is = JdbcUtils1.class.getClassLoader().getResourceAsStream(
				"dbconfig.properties");
		Properties props = new Properties();
		props.load(is);
		String driverClassName = props.getProperty("driverClassName");
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		Class.forName(driverClassName);
		return DriverManager.getConnection(url, username, password);
	}

	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
