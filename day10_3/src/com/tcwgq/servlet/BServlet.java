package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示响应编码
 * 
 * @author lenovo
 * 
 */
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应编码
		// response.setCharacterEncoding("utf-8");
		// 设置浏览器的解码
		// response.setHeader("content-type", "text/html;charset=utf-8");
		// 设置编码的便捷方法
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("你好，世界");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
