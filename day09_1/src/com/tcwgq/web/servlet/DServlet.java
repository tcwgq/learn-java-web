package com.tcwgq.web.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 继承GenericServlet实现servlet
 * 
 * @author lenovo
 * 
 */
public class DServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("哈哈哈~~~，我来也~~~");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {

	}

	@Override
	public void destroy() {
		System.out.println("我要死了~~~");
	}

}
