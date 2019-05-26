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
 * 过滤器是基于方法回调的 粗粒度权限控制
 * 
 * @author lenovo
 * 
 */
public class UserFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String admin = (String) session.getAttribute("admin");
		if (admin != null) {
			chain.doFilter(request, response);
			return;
		}
		String user = (String) session.getAttribute("user");
		if (user != null) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("msg", "您只是个游客，没有权限访问其他页面");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
