package com.tcwgq.bookstore.category.service;

import java.util.List;

import com.tcwgq.bookstore.book.dao.BookDao;
import com.tcwgq.bookstore.category.dao.CategoryDao;
import com.tcwgq.bookstore.category.domain.Category;
import com.tcwgq.bookstore.category.exception.CategoryException;

public class CategoryService {
	private CategoryDao dao = new CategoryDao();
	private BookDao bdao = new BookDao();

	public List<Category> findAll() {
		return dao.findAll();
	}

	public void add(Category category) {
		dao.add(category);
	}

	public void delete(String cid) throws CategoryException {
		int count = bdao.findCountByCategory(cid);
		if (count > 0) {
			throw new CategoryException("分类下存在图书，不能删除！");
		}
		dao.delete(cid);
	}

	public Category findByCid(String cid) {
		return dao.findByCid(cid);
	}

	public void update(Category category) {
		dao.update(category);
	}
}
