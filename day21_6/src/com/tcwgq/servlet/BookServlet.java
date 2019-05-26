package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.tcwgq.service.BookService;

public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService service = new BookService();

	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("books", service.findAll());
		return "f:/show.jsp";
	}

	public String findByCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("category");
		int category = Integer.parseInt(value);
		request.setAttribute("books", service.findByCategory(category));
		return "f:/show.jsp";
	}

}
