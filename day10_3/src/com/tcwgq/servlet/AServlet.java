package com.tcwgq.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request获取请求参数
 * 
 * @author lenovo
 * 
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 单值
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		// 多值
		String[] hobbies = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobbies));
		// 其他的获取请求参数的方法
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			String[] values = map.get(key);
			System.out.println(key + "=" + Arrays.toString(values));
		}
	}

}
