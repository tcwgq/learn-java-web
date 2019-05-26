package com.tcwgq.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/AServlet")
// 上传文件时，必须有下面这个注解
@MultipartConfig
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println(username);
		Part part = request.getPart("file");
		System.out.println(part.getContentType());
		System.out.println(part.getName());
		System.out.println(part.getSize());
		System.out.println(part.getHeader("Content-Disposition"));
		// 没有提供获取文件名称的方法，需要我们自己从Content-Disposition头中截取
		String data = part.getHeader("Content-Disposition");
		int start = data.lastIndexOf("=") + 2;
		int end = data.lastIndexOf("\"");
		String filename = data.substring(start, end);
		System.out.println(filename);
		part.write("d:/abc.png");
	}
}
