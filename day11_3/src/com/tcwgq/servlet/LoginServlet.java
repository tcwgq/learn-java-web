package com.tcwgq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先处理乱码问题
		request.setCharacterEncoding("utf-8");
		// 处理验证码
		String vcode = (String) request.getSession().getAttribute("vcode");
		String verifyCode = request.getParameter("verifyCode");
		if (!verifyCode.toLowerCase().equalsIgnoreCase(vcode)) {
			request.setAttribute("msg", "验证码错误！");
			request.getRequestDispatcher("/session2/login.jsp").forward(
					request, response);
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (!"zhangsan".equalsIgnoreCase(username)) {
			// 设置cookie，将先前填入的用户名显示在文本框中
			// 注意，只有登录成功后，下次登录才能显示上次的用户名
			Cookie cookie = new Cookie("name", username);
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("/day11_3/session2/succ1.jsp");
		} else {
			// Cookie cookie = new Cookie("name", username);
			// cookie.setMaxAge(60 * 60 * 24);
			// response.addCookie(cookie);
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("/session2/login.jsp").forward(
					request, response);
		}
	}

}
