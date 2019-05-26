package com.tcwgq.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 装饰response
 * 
 * @author lenovo
 * 
 */
public class StaticResponse extends HttpServletResponseWrapper {
	private PrintWriter pw;

	public StaticResponse(HttpServletResponse response, String path)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		// 创建一个和HTML绑定的流对象
		pw = new PrintWriter(path, "utf-8");
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return pw;
	}
}
