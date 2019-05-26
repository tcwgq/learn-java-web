package com.tcwgq.bookstore.book.service;

import java.util.List;

import com.tcwgq.bookstore.book.dao.BookDao;
import com.tcwgq.bookstore.book.domain.Book;

public class BookService {
	private BookDao dao = new BookDao();

	public List<Book> findAll() {
		return dao.findAll();
	}

	public List<Book> findByCategory(String cid) {
		return dao.findByCategory(cid);
	}

	public Book findById(String bid) {
		return dao.findById(bid);
	}

	public void addBook(Book book) {
		dao.add(book);
	}

	public void delete(String bid) {
		dao.delete(bid);
	}

	public void edit(Book book) {
		dao.update(book);
	}

}
