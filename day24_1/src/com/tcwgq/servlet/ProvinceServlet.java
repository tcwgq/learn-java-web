package com.tcwgq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.tcwgq.dao.Dao;
import com.tcwgq.domain.Province;

public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Dao dao = new Dao();
		List<Province> list = dao.findAllProvince();
		String s = JSONArray.fromObject(list).toString();
		response.getWriter().print(s);
	}

}
