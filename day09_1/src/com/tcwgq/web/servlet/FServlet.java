package com.tcwgq.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet的相关细节 
 * 1.serlvet是单例的，线程不安全，效率高 
 * 2.servlet中不要存在有状态的变量
 * 
 * @author lenovo
 * 
 */
public class FServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user = new User();

	@Override
	public void init() throws ServletException {
		System.out.println("Hello----------------------world");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()....");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()....");
	}

}
