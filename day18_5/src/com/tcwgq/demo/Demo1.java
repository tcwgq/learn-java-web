package com.tcwgq.demo;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.tcwgq.domain.Student;
import com.tcwgq.utils.JdbcUtils;

/**
 * 使用QueryRunner类，简化jdbc操作
 * 
 * @author lenovo
 * 
 */
public class Demo1 {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	@Test
	public void insert() throws SQLException {
		String sql = "insert into student values (?, ?)";
		Object[] params = new Object[] { null, "王五" };
		int row = qr.update(sql, params);
		System.out.println(row);
	}

	@Test
	public void select() throws SQLException {
		String sql = "select * from student where sid = ?";
		Object[] params = new Object[] { 1 };
		Student student = qr.query(sql,
				new BeanHandler<Student>(Student.class), params);
		System.out.println(student);
	}

	@Test
	public void update() throws SQLException {
		String sql = "update student set sname = ? where sid = ?";
		Object[] params = new Object[] { "wangwu", 4 };
		int row = qr.update(sql, params);
		System.out.println(row);
	}

	@Test
	public void delete() throws SQLException {
		String sql = "delete from student where sid = ?";
		Object[] params = new Object[] { 4 };
		int row = qr.update(sql, params);
		System.out.println(row);
	}
}
