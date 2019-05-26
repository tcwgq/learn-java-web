package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示302重定向
 * 
 * @author lenovo
 * 
 */
public class CServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 方式一
		// response.setHeader("Location", "/day10_1/DServlet");
		// response.setStatus(302);
		// 方式二 快捷重定向方法
		response.sendRedirect("/day10_1/DServlet");
		System.out.println("CServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
