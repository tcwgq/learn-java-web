package com.tcwgq.servlet.include;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ThreeServlet留头又留体
		 */
		System.out.println("ThreeServlet...");
		response.setHeader("three", "threethreethree");
		response.getWriter().write("three servlet" + "<br/>");
		request.getRequestDispatcher("/FourServlet").include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
