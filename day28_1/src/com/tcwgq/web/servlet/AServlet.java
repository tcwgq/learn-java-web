package com.tcwgq.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servelt3.0注解开发
 * 
 * @author lenovo
 * 
 */
@WebServlet(urlPatterns = { "/AServlet" }, initParams = { @WebInitParam(name = "p1", value = "v1") }, loadOnStartup = 1)
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet3.0");
		response.getWriter().print("Servlet3.0!");
	}
}
