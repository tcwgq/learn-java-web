package com.tcwgq.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcwgq.user.domain.User;
import com.tcwgq.user.service.UserService;
import com.tcwgq.user.service.userException;
import com.tcwgq.utils.CommonUtils;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		/**
		 * 验证表单数据
		 */
		Map<String, String> errors = new HashMap<String, String>();
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空！");
		} else if (username.length() < 3 || username.length() > 15) {
			errors.put("username", "用户名必须在3~15位!");
		}
		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		} else if (password.length() < 3 || password.length() > 15) {
			errors.put("password", "密码必须在3~15位!");
		}
		String vcode = (String) request.getSession().getAttribute("vcode");
		String verifyCode = form.getVerifyCode();
		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空！");
		} else if (verifyCode.length() != 4) {
			errors.put("verifyCode", "验证码必须为4位！");
		} else if (!verifyCode.equalsIgnoreCase(vcode)) {
			errors.put("verifyCode", "验证码错误！");
		}
		if (errors != null && errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);// 用于页面回显
			request.getRequestDispatcher("/user/regist.jsp").forward(request,
					response);
			return;
		}
		try {
			userService.regist(form);
			response.getWriter().print("<h1>注册成功!</h1>");
			String path = request.getContextPath();
			response.getWriter().print(
					"<a href='" + path + "/user/login.jsp" + "'>点击这里去登录</a>");
		} catch (userException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);// 用于页面回显
			request.getRequestDispatcher("/user/regist.jsp").forward(request,
					response);
		}
	}

}
