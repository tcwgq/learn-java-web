package com.tcwgq.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * 使用响应字节流发送文字或图片
 * 
 * @author lenovo
 * 
 */
public class HServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String s = "Hello ServletOutputStream";
		// byte[] bytes = s.getBytes();
		// response.getOutputStream().write(bytes);
		InputStream is = new FileInputStream(
				"D:/Develop/apache-tomcat-7.0.69/webapps/ROOT/tomcat.gif");
		// byte[] bys = new byte[1024];
		// int length = 0;
		// while ((length = is.read(bys)) != -1) {
		// response.getOutputStream().write(bys, 0, length);
		// }
		byte[] bys = IOUtils.toByteArray(is);
		response.getOutputStream().write(bys);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
