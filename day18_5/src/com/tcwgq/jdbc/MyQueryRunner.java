package com.tcwgq.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.tcwgq.utils.JdbcUtils;

public class MyQueryRunner<T> {
	private DataSource dataSource;

	public MyQueryRunner() {

	}

	public MyQueryRunner(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(null, ps, conn);
		}
	}

	public T query(String sql, MyHandler<T> rh, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			return rh.handle(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
