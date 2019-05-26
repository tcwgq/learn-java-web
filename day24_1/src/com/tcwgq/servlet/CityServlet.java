package com.tcwgq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.tcwgq.dao.Dao;
import com.tcwgq.domain.City;

public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		Dao dao = new Dao();
		List<City> list = dao.findCityByPid(pid);
		String s = JSONArray.fromObject(list).toString();
		response.getWriter().print(s);
	}

}
