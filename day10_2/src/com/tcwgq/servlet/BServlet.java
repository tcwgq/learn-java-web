package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用referer头，充当防盗链 直接从浏览器地址栏中访问网站，请求头中没有referer
 * 
 * @author lenovo
 * 
 */
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("referer");
		System.out.println(referer);
		if (referer == null) {
			System.out.println("欢迎通过浏览器地址栏访问本网站");
		} else {
			if (referer.equals("localhost")) {
				System.out.println("欢迎通过localhost访问本网站");
			} else {
				System.out.println("欢迎通过其他方式访问本网站");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
