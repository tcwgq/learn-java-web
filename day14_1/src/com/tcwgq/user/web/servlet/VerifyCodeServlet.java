package com.tcwgq.user.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcwgq.verify.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		VerifyCode vc = new VerifyCode();
		BufferedImage bi = vc.getImage();
		String text = vc.getText();
		request.getSession().setAttribute("vcode", text);
		VerifyCode.output(bi, response.getOutputStream());
	}

}
