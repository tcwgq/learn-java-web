package com.tcwgq.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面静态化
 * 
 * @author lenovo
 * 
 */
public class StaticFilter implements Filter {
	private ServletContext app;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String category = req.getParameter("category");
		String htmlPage = category + ".html";
		String htmlPath = app.getRealPath("/htmls");
		File file = new File(htmlPath, htmlPage);
		if (file.exists()) {
			res.sendRedirect(req.getContextPath() + "/htmls/" + htmlPage);
			return;
		}
		StaticResponse sr = new StaticResponse(res, file.getAbsolutePath());
		chain.doFilter(req, sr);
		// 页面已经存在，需要重定向
		res.sendRedirect(req.getContextPath() + "/htmls/" + htmlPage);
	}

	public void init(FilterConfig config) throws ServletException {
		this.app = config.getServletContext();
	}

}
