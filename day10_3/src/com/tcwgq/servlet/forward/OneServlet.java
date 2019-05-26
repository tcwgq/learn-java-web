package com.tcwgq.servlet.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示请求转发 OneServlet不要设置响应体，这样可能会出现无结果或异常
 * 
 * @author lenovo
 * 
 */
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * OneServlet留头不留体
		 */
		System.out.println("OneServlet...");
		// 设置响应头
		response.setHeader("one", "oneoneoneone");
		// 设置响应体
		// for (int i = 0; i < 1024 * 24 + 1; i++) {
		// response.getWriter().write("one servlet");
		// }
		/**
		 * 向request域中保存数据
		 */
		request.setAttribute("aaa", "AAA");
		// 请求转发到TwoServlet，相当于调用TwoServlet的service方法
		request.getRequestDispatcher("/TwoServlet").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
