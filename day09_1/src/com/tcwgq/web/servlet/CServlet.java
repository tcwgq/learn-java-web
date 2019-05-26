package com.tcwgq.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义Servlet实现GenericServlet的相关功能
 * 
 * @author lenovo
 * 
 */
public class CServlet extends BServlet {
	@Override
	public void init() {
		System.out.println("哇~~~~我活了，我很高兴~~~~");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		String value = getInitParameter("p1");
	}
}
