package com.tcwgq.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servle是单例模式的，一个servlet只有一个实例。 servlet是线程不安全的。
 * 
 * @author lenovo
 * 
 */
public class AServlet implements Servlet {
	/**
	 * 生命周期方法 它会在servlet被销毁前调用，并且只调用一次。
	 */
	@Override
	public void destroy() {
		System.out.println("destroy()...");
	}

	/**
	 * 获取servlet的配置信息。
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig()...");
		return null;
	}

	/**
	 * 获取servlet的信息。
	 */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		return "我是一个快乐的servlet";
	}

	/**
	 * 生命周期方法，它会在servlet对象创建之后马上执行，并且只执行一次。 它会被调用多次。 每次处理请求都在调用这个方法。
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init()...");

	}

	/**
	 * 生命周期方法
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service()...");

	}

}
