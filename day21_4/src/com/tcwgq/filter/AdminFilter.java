package com.tcwgq.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 拦截管理员
 * 
 * @author lenovo
 * 
 */
public class AdminFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String admin = (String) session.getAttribute("admin");
		if (admin != null) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("msg", "您不是管理员，没有权限访问管理员页面");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
