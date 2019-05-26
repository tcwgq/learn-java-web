package com.tcwgq.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilsTest {
	public static void main(String[] args) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}
}
