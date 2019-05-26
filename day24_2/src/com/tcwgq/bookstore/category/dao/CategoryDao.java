package com.tcwgq.bookstore.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.tcwgq.bookstore.category.domain.Category;

public class CategoryDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Category> findAll() {
		String sql = "select * from category";
		try {
			List<Category> list = qr.query(sql, new BeanListHandler<Category>(
					Category.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void add(Category category) {
		String sql = "insert into category values (?, ?)";
		try {
			qr.update(sql, category.getCid(), category.getCname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String cid) {
		String sql = "delete from category where cid = ?";
		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Category findByCid(String cid) {
		String sql = "select * from category where cid = ?";
		try {
			Category category = qr.query(sql, new BeanHandler<Category>(
					Category.class), cid);
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Category category) {
		String sql = "update category set cname = ? where cid = ?";
		try {
			qr.update(sql, category.getCname(), category.getCid());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
