package com.tcwgq.junit.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.tcwgq.utils.JdbcUtils;

/**
 * 大数据
 * 
 * @author lenovo
 * 
 */
public class Demo5 {
	@Test
	public void save() throws SQLException {
		String sql = "insert into tb_bin values (?, ?, ?)";
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setString(2, "周杰伦-七里香.mp3");
		InputStream is = Demo5.class.getClassLoader().getResourceAsStream(
				"周杰伦-七里香.mp3");
		ps.setBlob(3, is);
		ps.executeUpdate();
		System.out.println("success");
		JdbcUtils.free(null, ps, conn);
	}

	@Test
	public void get() throws SQLException, FileNotFoundException, IOException {
		String sql = "select * from tb_bin";
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String fileName = rs.getString("filename");
			Blob blob = rs.getBlob("data");
			InputStream is = blob.getBinaryStream();
			IOUtils.copy(is, new FileOutputStream("七里香.mp3"));
			System.out.println(id + "--" + fileName);
		}
		System.out.println("success");
		JdbcUtils.free(rs, ps, conn);
	}
}
