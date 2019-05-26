package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("add...");
	}

	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("update...");
		throw new RuntimeException("我出错了，哈哈哈");
	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("delete...");
	}

}
