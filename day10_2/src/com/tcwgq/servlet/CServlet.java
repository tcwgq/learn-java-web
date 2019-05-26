package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过request获取请求URL的相关方法
 * 
 * @author lenovo
 * 
 */
public class CServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * http://localhost:8080/day10_2/CServlet?username=zhangSan&password=123
		 */
		System.out.println(request.getProtocol());// HTTP/1.1
		System.out.println(request.getScheme());// http
		System.out.println(request.getServerName());// localhost
		System.out.println(request.getServerPort());// 8080
		System.out.println(request.getContextPath());// /day10_2，这个最常用
		System.out.println(request.getServletPath());// /CServlet
		System.out.println(request.getQueryString());// username=zhangSan&password=123
		System.out.println(request.getRequestURI());// /day10_2/CServlet
		System.out.println(request.getRequestURL());// http://localhost:8080/day10_2/CServlet

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
