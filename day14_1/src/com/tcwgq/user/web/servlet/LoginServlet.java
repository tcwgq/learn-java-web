package com.tcwgq.user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcwgq.user.domain.User;
import com.tcwgq.user.service.UserService;
import com.tcwgq.user.service.userException;
import com.tcwgq.utils.CommonUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("session_user", user);
			response.sendRedirect(request.getContextPath()
					+ "/user/welcome.jsp");
		} catch (userException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/login.jsp").forward(request,
					response);
		}

	}
}
