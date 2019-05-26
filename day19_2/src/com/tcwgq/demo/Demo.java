package com.tcwgq.demo;

import java.sql.SQLException;

import org.junit.Test;

import com.tcwgq.dao.AccountDao;
import com.tcwgq.utils.JdbcUtils;

/**
 * 测试JdbcUtils
 * 
 * @author lenovo
 * 
 */
public class Demo {
	private AccountDao dao = new AccountDao();

	@Test
	public void fun() throws SQLException {
		try {
			JdbcUtils.beginTransaction();
			dao.update("张三", -100);
			int a = 10 / 0;
			System.out.println(a);
			dao.update("李四", 100);
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			JdbcUtils.rollbackTransaction();
			throw new RuntimeException(e);
		}
	}

}
