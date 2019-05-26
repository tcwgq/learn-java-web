package com.tcwgq.dao;

import java.util.List;

import org.junit.Test;

import com.tcwgq.domain.Book;

public class BookDaoTest {
	private BookDao dao = new BookDao();

	@Test
	public void testFindAll() {
		List<Book> books = dao.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testFindByCategory() {
		List<Book> books = dao.findByCategory(1);
		for (Book book : books) {
			System.out.println(book);
		}
	}

}
