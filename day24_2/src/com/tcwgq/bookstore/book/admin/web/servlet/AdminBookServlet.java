package com.tcwgq.bookstore.book.admin.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.bookstore.book.domain.Book;
import com.tcwgq.bookstore.book.service.BookService;
import com.tcwgq.bookstore.category.domain.Category;
import com.tcwgq.bookstore.category.service.CategoryService;

public class AdminBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService service = new BookService();
	CategoryService categoryService = new CategoryService();

	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Book> books = service.findAll();
		request.setAttribute("books", books);
		return "f:/adminjsps/admin/book/list.jsp";
	}

	public String loadBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String bid = request.getParameter("bid");
		Book book = service.findById(bid);
		List<Category> categories = categoryService.findAll();
		request.setAttribute("book", book);
		request.setAttribute("categories", categories);
		return "f:/adminjsps/admin/book/desc.jsp";
	}

	public String addPre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Category> categories = categoryService.findAll();
		request.setAttribute("categories", categories);
		return "f:/adminjsps/admin/book/add.jsp";
	}

	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String bid = request.getParameter("bid");
		service.delete(bid);
		List<Book> books = service.findAll();
		request.setAttribute("books", books);
		return "f:/adminjsps/admin/book/list.jsp";
	}

	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
		Category category = CommonUtils.toBean(request.getParameterMap(),
				Category.class);
		book.setCategory(category);
		service.edit(book);
		List<Book> books = service.findAll();
		request.setAttribute("books", books);
		return "f:/adminjsps/admin/book/list.jsp";
	}

}
