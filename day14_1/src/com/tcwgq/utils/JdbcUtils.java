package com.tcwgq.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JdbcUtils
 * 
 * @author lenovo
 * 
 */
public class JdbcUtils {
	private static Properties props = null;
	static {
		InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream(
				"dbconfig.properties");
		props = new Properties();
		try {
			props.load(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("username"), props.getProperty("password"));
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
