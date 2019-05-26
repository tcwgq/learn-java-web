package com.tcwgq.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sf = new ServletFileUpload(factory);
		try {
			List<FileItem> list = sf.parseRequest(request);
			FileItem fi1 = list.get(0);
			// 获取普通表单项的值
			System.out.println(fi1.getFieldName() + "="
					+ fi1.getString("utf-8"));
			System.out.println("-------------------------");
			FileItem fi2 = list.get(1);
			System.out.println(fi2.getContentType());
			System.out.println(fi2.getSize());
			// 获取文件名称
			System.out.println(fi2.getName());
			// 保存文件
			fi2.write(new File("d:/abc.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
