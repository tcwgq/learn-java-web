package com.tcwgq.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method").trim();
		if (methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("没有传递参数，无法确定调用哪个方法");
		}
		Method method = null;
		try {
			method = this.getClass().getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("方法" + methodName + "不存在");
		}
		try {
			String result = (String) method.invoke(this, request, response);
			if (result == null || result.trim().isEmpty()) {
				// 什么也不做
				return;
			}

			if (result.contains(":")) {
				int index = result.indexOf(":");
				String prefix = result.substring(0, index);
				String path = result.substring(index + 1);
				if (prefix.equalsIgnoreCase("r")) {
					request.getRequestDispatcher(path).forward(request,
							response);
				} else if (prefix.equalsIgnoreCase("f")) {
					response.sendRedirect(request.getContextPath() + path);
				} else {
					throw new RuntimeException("不支持此功能");
				}
			} else {
				// 没有指定前缀，默认为转发
				request.getRequestDispatcher(result).forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("方法" + methodName + "内部出现异常");
			throw new RuntimeException(e);
		}
	}

}
