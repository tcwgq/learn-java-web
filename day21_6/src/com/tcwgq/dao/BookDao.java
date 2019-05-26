package com.tcwgq.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.tcwgq.domain.Book;

public class BookDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Book> findAll() {
		String sql = "select * from t_book";
		try {
			List<Book> books = qr.query(sql, new BeanListHandler<Book>(
					Book.class));
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Book> findByCategory(int category) {
		String sql = "select * from t_book where category = ?";
		try {
			List<Book> books = qr.query(sql, new BeanListHandler<Book>(
					Book.class), category);
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
