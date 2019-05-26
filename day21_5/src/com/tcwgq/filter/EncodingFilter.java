package com.tcwgq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 全站编码问题
 * 
 * @author lenovo
 * 
 */
public class EncodingFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		EncodingRequest er = new EncodingRequest(req);
		chain.doFilter(er, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
