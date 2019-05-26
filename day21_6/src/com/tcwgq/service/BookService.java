package com.tcwgq.service;

import java.util.List;
import com.tcwgq.dao.BookDao;
import com.tcwgq.domain.Book;

public class BookService {
	private BookDao dao = new BookDao();

	public List<Book> findAll() {
		return dao.findAll();
	}

	public List<Book> findByCategory(int category) {
		return dao.findByCategory(category);
	}
}
