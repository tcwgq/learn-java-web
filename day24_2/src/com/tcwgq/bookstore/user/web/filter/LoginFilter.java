package com.tcwgq.bookstore.user.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.tcwgq.bookstore.user.domain.User;

public class LoginFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		if (user != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("msg", "请先登录！");
			request.getRequestDispatcher("/jsps/user/login.jsp").forward(
					request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
