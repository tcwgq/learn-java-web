package com.tcwgq.bookstore.category.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.tcwgq.bookstore.category.service.CategoryService;

public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service = new CategoryService();

	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("categories", service.findAll());
		return "f:/jsps/left.jsp";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

	}

}
