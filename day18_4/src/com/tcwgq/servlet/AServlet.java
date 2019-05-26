package com.tcwgq.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * 给tomcat配置数据源
 * 
 * @author lenovo
 * 
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Context context;
		try {
			context = new InitialContext();
			Context ctx = (Context) context.lookup("java:comp/env");
			DataSource dataSource = (DataSource) ctx.lookup("jdbc/dataSource");
			// 这样也可以
			DataSource ds = (DataSource) context
					.lookup("java:comp/env/jdbc/dataSource");
			System.out.println(ds);
			Connection conn = dataSource.getConnection();
			System.out.println(conn.getClass().getName());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
