package com.tcwgq.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		String province = request.getParameter("province");
		SAXReader reader = new SAXReader();
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("china.xml");
		try {
			Document document = reader.read(is);
			Element ele = (Element) document
					.selectSingleNode("//province[@name='" + province + "']");
			String xml = ele.asXML();
			response.getWriter().print(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
