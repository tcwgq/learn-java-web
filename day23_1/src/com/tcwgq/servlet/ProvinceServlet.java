package com.tcwgq.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		SAXReader reader = new SAXReader();
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("china.xml");
		try {
			Document document = reader.read(is);
			@SuppressWarnings("unchecked")
			List<Attribute> arrList = document.selectNodes("//province/@name");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arrList.size(); i++) {
				sb.append(arrList.get(i).getValue());
				if (i < arrList.size() - 1) {
					sb.append(",");
				}
			}
			response.getWriter().print(sb);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
