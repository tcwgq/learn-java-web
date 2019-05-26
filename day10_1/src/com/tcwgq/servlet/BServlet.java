package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置响应头的相关方法
 * 结合httpwatch在浏览器端可以看见相关设置
 * 
 * @author lenovo
 * 
 */
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 单值的响应头
		response.setHeader("aaa", "AAA");
		// 多值的响应头
		response.addHeader("bbb", "B");
		response.addHeader("bbb", "BB");
		response.addHeader("bbb", "BBB");
		// 单值得int类型的响应头
		response.setIntHeader("Content-Length", 10);
		// 多值得int类型的响应头
		response.addIntHeader("ccc", 1);
		response.addIntHeader("ccc", 2);
		response.addIntHeader("ccc", 3);
		// 单值的毫秒类型的响应头
		response.addDateHeader("expires", 1000 * 60);
		// 多值的毫秒类型的响应头
		response.addDateHeader("ddd", 1000 * 60 * 1);
		response.addDateHeader("ddd", 1000 * 60 * 2);
		response.addDateHeader("ddd", 1000 * 60 * 3);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
