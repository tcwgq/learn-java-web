package com.tcwgq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统计网站访问量案例
 * 
 * @author lenovo
 * 
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		if (count == null) {
			count = 1;
			application.setAttribute("count", count);
		} else {
			count += 1;
			application.setAttribute("count", count);
		}
		PrintWriter pw = response.getWriter();
		pw.write("<h1>" + count + "</h1>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
