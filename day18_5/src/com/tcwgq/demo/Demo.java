package com.tcwgq.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.tcwgq.domain.Student;
import com.tcwgq.jdbc.MyHandler;
import com.tcwgq.jdbc.MyQueryRunner;
import com.tcwgq.utils.JdbcUtils;

/**
 * 使用自定义QueryRunner类
 * 
 * @author lenovo
 * 
 */
public class Demo {
	private MyQueryRunner<Student> qr = new MyQueryRunner<Student>(
			JdbcUtils.getDataSource());

	@Test
	public void insert() {
		String sql = "insert into student values (?, ?)";
		Object[] params = new Object[] { null, "王五" };
		int row = qr.update(sql, params);
		System.out.println(row);
	}

	@Test
	public void select() {
		String sql = "select * from student where sid = ?";
		Object[] params = new Object[] { 1 };
		MyHandler<Student> rh = new MyHandler<Student>() {
			@Override
			public Student handle(ResultSet rs) throws SQLException {
				Student student = null;
				if (rs.next()) {
					student = new Student(rs.getInt("sid"),
							rs.getString("sname"));
				}
				return student;
			}
		};
		Student student = qr.query(sql, rh, params);
		System.out.println(student);
	}

	@Test
	public void update() {
		String sql = "update student set sname = ? where sid = ?";
		Object[] params = new Object[] { "wangwu", 3 };
		int row = qr.update(sql, params);
		System.out.println(row);
	}

	@Test
	public void delete() {
		String sql = "delete from student where sid = ?";
		Object[] params = new Object[] { 3 };
		int row = qr.update(sql, params);
		System.out.println(row);
	}
}
