package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取客户端IP地址，请求方式以及user-agent信息
 * 
 * @author lenovo
 * 
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getMethod());
		String userAgent = request.getHeader("user-agent");
		System.out.println(userAgent);
		// IE11通过下面这种方式识别不出来
		if (userAgent.toLowerCase().contains("chrome")) {
			System.out.println("谷歌浏览器");
		} else if (userAgent.toLowerCase().contains("firefox")) {
			System.out.println("火狐浏览器");
		} else if (userAgent.toLowerCase().contains("msie")) {
			System.out.println("IE浏览器");
		} else {
			System.out.println("您用的浏览器我没见过");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
