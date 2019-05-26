package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示请求编码
 * 
 * @author lenovo
 * 
 */
public class CServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		byte[] bys = username.getBytes("iso-8859-1");// 回退
		username = new String(bys, "utf-8");// 重编
		System.out.println(username);
		System.out.println(request.getParameter("password"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 在获取参数之前，先调用setCharacterEncoding()方法，就能保证不乱码
		 */
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
	}

}
