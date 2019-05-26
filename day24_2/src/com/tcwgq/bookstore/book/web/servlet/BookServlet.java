package com.tcwgq.bookstore.book.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.tcwgq.bookstore.book.domain.Book;
import com.tcwgq.bookstore.book.service.BookService;

public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService service = new BookService();

	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Book> books = service.findAll();
		request.setAttribute("books", books);
		return "f:/jsps/book/list.jsp";
	}

	public String findByCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String cid = request.getParameter("cid");
		List<Book> books = service.findByCategory(cid);
		request.setAttribute("books", books);
		return "f:/jsps/book/list.jsp";
	}

	public String loadBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String bid = request.getParameter("bid");
		Book book = service.findById(bid);
		request.setAttribute("book", book);
		return "f:/jsps/book/desc.jsp";
	}

}
