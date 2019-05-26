package com.tcwgq.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 自定义Servlet实现GenericServlet的相关功能
 * 
 * @author lenovo
 * 
 */
public class BServlet implements Servlet {
	private ServletConfig config;

	@Override
	public void destroy() {
		System.out.println("我要死了~");
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "我是BServlet";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	public void init() {

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("我是service方法");
	}

	public ServletContext getServletContext() {
		return config.getServletContext();
	}

	public String getServletName() {
		return config.getServletName();
	}

	public String getInitParameter(String name) {
		return config.getInitParameter(name);
	}

}
