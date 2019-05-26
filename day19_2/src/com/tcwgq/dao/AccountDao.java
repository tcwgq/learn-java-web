package com.tcwgq.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.tcwgq.jdbc.TxQueryRunner;
import com.tcwgq.utils.JdbcUtils;

/**
 * AccountDao
 * 
 * @author lenovo
 * 
 */
public class AccountDao {
	public void update(String name, double money) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "update account set balance=balance+? where name =?";
		Object[] params = { money, name };
		Connection conn = JdbcUtils.getConnection();
		qr.update(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
	}
}
