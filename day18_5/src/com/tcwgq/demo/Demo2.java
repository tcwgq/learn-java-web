package com.tcwgq.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.tcwgq.domain.Student;
import com.tcwgq.utils.JdbcUtils;

/**
 * ResultSetHandler结果集处理器介绍
 * 
 * @author lenovo
 * 
 */
public class Demo2 {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	@Test
	public void fun1() throws SQLException {
		String sql = "select * from student where sid = ?";
		Object[] params = new Object[] { 1 };
		Student student = qr.query(sql,
				new BeanHandler<Student>(Student.class), params);
		System.out.println(student);
	}

	@Test
	public void fun2() throws SQLException {
		String sql = "select * from student";
		Object[] params = null;
		List<Student> students = (List<Student>) qr.query(sql,
				new BeanListHandler<Student>(Student.class), params);
		for (Student s : students) {
			System.out.println(s);
		}
	}

	@Test
	public void fun3() throws SQLException {
		String sql = "select * from student where sid = ?";
		Object[] params = new Object[] { 1 };
		Map<String, Object> student = qr.query(sql, new MapHandler(), params);
		System.out.println(student);
	}

	@Test
	public void fun4() throws SQLException {
		String sql = "select * from student";
		List<Map<String, Object>> students = qr
				.query(sql, new MapListHandler());
		for (Map<String, Object> map : students) {
			System.out.println(map);
		}
	}

	@Test
	public void fun5() throws SQLException {
		String sql = "select count(*) from student";
		// 不同数据库驱动，返回的类型不同，因此先转化为Number类型，然后根据实际需要转换为具体类型
		Number count = qr.query(sql, new ScalarHandler<Long>());
		Long result = count.longValue();
		System.out.println(result);
	}
}
