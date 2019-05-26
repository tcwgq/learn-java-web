package com.tcwgq.basedao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import cn.itcast.jdbc.TxQueryRunner;

public class Demo {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 回忆一下使用dbutils
	 * 
	 * @throws SQLException
	 * 
	 */
	public void addUser(User user) throws SQLException {
		String sql = "";
		Object[] params = {};
		qr.update(sql, params);
	}

	public void addCategory(Student student) throws SQLException {
		String sql = "";
		Object[] params = {};
		qr.update(sql, params);
	}
}

class BaseDAO<T> {
	private QueryRunner qr = new TxQueryRunner();
	private Class<T> beanClass;

	public BaseDAO() {
		beanClass = (Class) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void add(T bean) throws SQLException {
		Field[] fs = beanClass.getDeclaredFields();

		String sql = "insert into " + beanClass.getSimpleName() + " values(";
		for (int i = 0; i < fs.length; i++) {
			sql += "?";
			if (i < fs.length - 1) {
				sql += ",";
			}
		}
		sql += ")";
		Object[] params = {/* 参数值是什么 */};
		qr.update(sql, params);
	}

	public void update(T bean) {

	}

	public void delete(String uuid) {

	}

	public T load(String uuid) {
		return null;
	}

	public List<T> findAll() {
		return null;
	}
}

class UserDAO extends BaseDAO<User> {
	public void addUser(User user) {
		// super.add(user);
	}
}
