package com.tcwgq.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 装饰者模式，添加编码功能
 * 
 * @author lenovo
 * 
 */
public class EncodingRequest extends HttpServletRequestWrapper {
	private HttpServletRequest req;

	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.req = request;
	}

	@Override
	public String getParameter(String name) {
		// 处理get请求
		String value = null;
		try {
			byte[] bys = req.getParameter(name).getBytes("iso-8859-1");
			value = new String(bys, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public void setCharacterEncoding(String enc)
			throws UnsupportedEncodingException {
		// 处理post请求
		super.setCharacterEncoding("utf-8");
	}

}
