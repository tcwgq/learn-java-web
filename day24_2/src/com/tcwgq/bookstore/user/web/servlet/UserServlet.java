package com.tcwgq.bookstore.user.web.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.bookstore.cart.domain.Cart;
import com.tcwgq.bookstore.user.domain.User;
import com.tcwgq.bookstore.user.exception.UserException;
import com.tcwgq.bookstore.user.service.UserService;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserService();

	public String regist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		form.setUid(CommonUtils.uuid());
		form.setCode(CommonUtils.uuid() + CommonUtils.uuid());
		form.setState(false);// 没激活，状态为false
		Map<String, String> errors = new HashMap<String, String>();
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空！");
		} else if (username.length() < 3 || username.length() > 10) {
			errors.put("username", "用户名长度必须为3~10位！");
		}
		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		} else if (password.length() < 3 || password.length() > 10) {
			errors.put("password", "密码长度必须为3~10位！");
		}
		String email = form.getEmail();
		if (email == null || email.trim().isEmpty()) {
			errors.put("email", "邮箱不能为空！");
		} else if (!email
				.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")) {
			errors.put("email", "邮箱格式不正确！");
		}
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
		}
		try {
			service.regist(form);
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
		}
		request.setAttribute("msg", "注册成功！激活邮件已发送到您的邮箱，请到邮箱查看！");
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader()
				.getResourceAsStream("email-template.properties"));
		String email_host = props.getProperty("email.host");
		String email_username = props.getProperty("email.username");
		String email_password = props.getProperty("email.password");
		String email_from = props.getProperty("email.from");
		String email_to = form.getEmail();
		String email_subject = props.getProperty("email.subject");
		String email_content = props.getProperty("email.content");
		email_content = MessageFormat.format(email_content, form.getCode());
		Session session = MailUtils.createSession(email_host, email_username,
				email_password);
		Mail mail = new Mail(email_from, email_to, email_subject, email_content);
		try {
			MailUtils.send(session, mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "f:/jsps/msg.jsp";
	}

	public String active(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String code = request.getParameter("code");
		try {
			service.active(code);
			request.setAttribute("msg", "激活成功！请登录！");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/msg.jsp";
	}

	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = service.login(form);
			request.getSession().setAttribute("user", user);
			// 添加购物车
			request.getSession().setAttribute("cart", new Cart());
			return "r:/index.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}
	}

	public String quit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/index.jsp";
	}

}
