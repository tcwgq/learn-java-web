package com.tcwgq.web.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AServlet", asyncSupported = true)
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// 不设置编码，会导致异步失败
		// IE11还不支持，到谷歌浏览器上才能看到效果
		response.setContentType("text/html;charset=utf-8");
		// 为了在IE上能看到效果，加上以下一段代码，亲测还是不行！
		for (int i = 0; i <= 512; i++) {
			response.getWriter().print("a");
		}
		response.getWriter().print("<br/>");
		response.getWriter().flush();
		final AsyncContext startAsync = request.startAsync(request, response);
		startAsync.start(new Runnable() {
			@Override
			public void run() {
				try {
					response.getWriter().print("hello");
					response.getWriter().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					response.getWriter().print("world");
					response.getWriter().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 告诉tomcat异步线程执行结束，这样才能及时的断开与浏览器的连接
				startAsync.complete();
			}
		});
	}
}
