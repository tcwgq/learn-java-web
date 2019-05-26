package com.tcwgq.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * 获取类路径下的资源 类路径的根 路径的为/WEB-INF/classes和/WEB-INF/lib/各种jar包
 * 
 * @author lenovo
 * 
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassLoader cl = this.getClass().getClassLoader();
		// 相对于/WEB-INF/classes
		// InputStream is = cl.getResourceAsStream("com/tcwgq/servlet/a.txt");
		Class c = this.getClass();
		// 相对于当前.class文件所在的目录
		// InputStream is = c.getResourceAsStream("a.txt");
		// 相对于classes目录
		// InputStream is = c.getResourceAsStream("/a.txt");
		// 获取web根目录下的index.jsp
		InputStream is = c.getResourceAsStream("/../../index.jsp");
		String s = IOUtils.toString(is);
		System.out.println(s);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
