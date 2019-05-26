package com.tcwgq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 用户自定义过滤器
 * 
 * @author lenovo
 * 
 */
public class AFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// System.out.println("我出生了，哈哈哈");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("AFilter#start");
		chain.doFilter(request, response);// 放行
		System.out.println("AFilter#end");
	}

	@Override
	public void destroy() {
		// System.out.println("我要死了，啊啊啊");
	}

}
