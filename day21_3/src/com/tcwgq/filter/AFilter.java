package com.tcwgq.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter {
	private ServletContext app;

	public void init(FilterConfig config) throws ServletException {
		this.app = config.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		@SuppressWarnings("unchecked")
		Map<String, Integer> map = (Map<String, Integer>) app
				.getAttribute("map");
		String ip = request.getRemoteAddr();
		if (map.containsKey(ip)) {
			Integer count = map.get(ip);
			count = count + 1;
			map.put(ip, count);
		} else {
			Integer count = 1;
			map.put(ip, count);
		}
		app.setAttribute("map", map);// 放不放都行，用的是引用
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
