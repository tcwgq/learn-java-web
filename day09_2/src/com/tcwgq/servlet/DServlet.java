package com.tcwgq.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用SercletContext获取资源路径
 * 
 * @author lenovo
 * 
 */
public class DServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到的是带盘符的路径
		// D:\Develop\apache-tomcat-7.0.69\webapps\day09_2\index.jsp
		// '/'的作用一定要搞明白，它代表项目根路径
		String path = this.getServletContext().getRealPath("/index.jsp");
		System.out.println(path);
		// 获取资源路径后，在转换为流对象
		// InputStream is = new FileInputStream(path);
		InputStream is = this.getServletContext().getResourceAsStream(path);
		// 获取根目录下指定目录下的所有文件路径
		Set<?> paths = this.getServletContext().getResourcePaths("/WEB-INF");
		System.out.println(paths);
		String contextPath = this.getServletContext().getContextPath();
		System.out.println(contextPath);// /day09_2

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
