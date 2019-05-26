package com.tcwgq.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JdbcUtils1.3
 * 
 * @author lenovo
 * 
 */
public class JdbcUtils4 {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = tl.get();
		// conn不为null，说明已经开启了事务
		if (conn != null)
			return conn;
		return dataSource.getConnection();
	}

	public static void beginTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn != null)
			throw new RuntimeException("已经开启事务，不要重复开启");
		conn = getConnection();
		conn.setAutoCommit(false);
		tl.set(conn);
	}

	public static void commitTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn == null)
			throw new RuntimeException("没开启事务，不能提交");
		conn.commit();
		conn.close();
		// 重置conn为null，防止事务之内获取连接时用的是事务的连接
		// conn = null;
		tl.remove();
	}

	public static void rollbackTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn == null)
			throw new RuntimeException("没开启事务，不能回滚");
		conn.rollback();
		conn.close();
		// 重置conn为null，防止事务之内获取连接时用的是事务的连接
		// conn = null;
		tl.remove();
	}

	public static void releaseConnection(Connection connection)
			throws SQLException {
		Connection conn = tl.get();
		// conn为null，说明连接不是事务连接，可以关闭
		if (conn == null)
			connection.close();
		// 如果conn != null，此时需要判断参数连接和事务连接是否为同一个
		if (conn != connection)
			connection.close();
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
