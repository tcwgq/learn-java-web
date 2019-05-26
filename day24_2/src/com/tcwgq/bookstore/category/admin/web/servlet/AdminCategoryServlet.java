package com.tcwgq.bookstore.category.admin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.bookstore.category.domain.Category;
import com.tcwgq.bookstore.category.exception.CategoryException;
import com.tcwgq.bookstore.category.service.CategoryService;

public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service = new CategoryService();

	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("categories", service.findAll());
		return "f:/adminjsps/admin/category/list.jsp";
	}

	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Category form = CommonUtils.toBean(request.getParameterMap(),
				Category.class);
		form.setCid(CommonUtils.uuid());
		service.add(form);
		return findAll(request, response);
	}

	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String cid = request.getParameter("cid");
		try {
			service.delete(cid);
		} catch (CategoryException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/adminjsps/msg.jsp";
		}
		return findAll(request, response);
	}

	public String loadCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String cid = request.getParameter("cid");
		Category category = service.findByCid(cid);
		request.setAttribute("category", category);
		return "f:/adminjsps/admin/category/mod.jsp";
	}

	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Category form = CommonUtils.toBean(request.getParameterMap(),
				Category.class);
		service.update(form);
		return findAll(request, response);
	}
}
