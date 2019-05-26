package com.tcwgq.servlet.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * TwoServlet留头又留体
		 */
		System.out.println("TwoServlet...");
		response.setHeader("two", "twotwotwotwo");
		response.getWriter().write("two servlet");
		String aaa = (String) request.getAttribute("aaa");
		System.out.println(aaa);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
