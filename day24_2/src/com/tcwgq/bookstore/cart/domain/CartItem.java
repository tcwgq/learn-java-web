package com.tcwgq.bookstore.cart.domain;

import java.math.BigDecimal;

import com.tcwgq.bookstore.book.domain.Book;

public class CartItem {
	private Book book;
	private int count;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSubtotal() {
		// 此处需要考虑二进制运算误差的问题，详情请看test
		// 必须使用字符串的构造方法才能避免误差
		BigDecimal price = new BigDecimal(book.getPrice() + "");
		BigDecimal num = new BigDecimal(count + "");
		return price.multiply(num).doubleValue();
	}
}
