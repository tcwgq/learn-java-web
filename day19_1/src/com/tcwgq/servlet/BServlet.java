package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String fun1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fun1...");
		return "/index.jsp";
	}

	public String fun2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fun2...");
		return "f:/index.jsp";
	}

	public String fun3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fun2...");
		return "d:/WEB-INF/images/a.jpg";
	}

	public String fun4(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fun4...");
		return null;
	}
}
