package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 禁用浏览器缓存
 * 
 * @author lenovo
 * 
 */
public class GServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print("Hello world!");
		/**
		 * Cache-Control, pragma, expires
		 */
		response.setHeader("cache-control", "no-cache");
		response.setHeader("pragma", "no-cache");
		response.setHeader("expires", "-1");// 0, -1都表示立即过期
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
