package com.tcwgq.bookstore.book.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.bookstore.book.domain.Book;
import com.tcwgq.bookstore.category.domain.Category;

public class BookDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Book> findAll() {
		String sql = "select * from book where del = false";
		try {
			List<Book> books = qr.query(sql, new BeanListHandler<Book>(
					Book.class));
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Book> findByCategory(String cid) {
		String sql = "select * from book where cid = ? and del = false";
		try {
			List<Book> books = qr.query(sql, new BeanListHandler<Book>(
					Book.class), cid);
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Book findById(String bid) {
		String sql = "select * from book where bid = ?";
		try {
			Map<String, Object> map = qr.query(sql, new MapHandler(), bid);
			Book book = CommonUtils.toBean(map, Book.class);
			Category category = CommonUtils.toBean(map, Category.class);
			book.setCategory(category);
			return book;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int findCountByCategory(String cid) {
		String sql = "select count(*) from book where cid = ?";
		try {
			Number number = qr.query(sql, new ScalarHandler<Long>(), cid);
			return number.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void add(Book book) {
		String sql = "insert into book values (?, ?, ?, ?, ?, ?, false)";
		Object[] params = { book.getBid(), book.getBname(), book.getPrice(),
				book.getAuthor(), book.getImage(), book.getCategory().getCid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 删除不是真的删，是假删除
	public void delete(String bid) {
		String sql = "update book set del=true where bid = ?";
		try {
			qr.update(sql, bid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Book book) {
		String sql = "update book set bname=?, price=?, author=?, image=?, cid=?, del=false where bid = ?";
		Object[] params = { book.getBname(), book.getPrice(), book.getAuthor(),
				book.getImage(), book.getCategory().getCid(), book.getBid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
