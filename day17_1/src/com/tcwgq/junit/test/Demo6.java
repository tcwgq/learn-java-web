package com.tcwgq.junit.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.tcwgq.utils.JdbcUtils;

/**
 * 批处理
 * 
 * @author lenovo
 * 
 */
public class Demo6 {
	@Test
	public void batchSave() throws SQLException {
		String sql = "insert into stu values (?, ?, ?, ?)";
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 1; i <= 10000; i++) {
			ps.setString(1, "no_" + i);
			ps.setString(2, "name_" + i);
			ps.setInt(3, i);
			if (i % 2 == 0) {
				ps.setString(4, "男");
			} else {
				ps.setString(4, "女");
			}
			ps.addBatch();
		}
		long start = System.currentTimeMillis();
		ps.executeBatch();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		JdbcUtils.free(null, ps, conn);
		// rewriteBatchedStatements=true
	}
}
