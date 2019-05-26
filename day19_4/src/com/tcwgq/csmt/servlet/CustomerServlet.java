package com.tcwgq.csmt.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.csmt.domain.Customer;
import com.tcwgq.csmt.domain.PageBean;
import com.twgq.csmt.service.CustomerService;

public class CustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service = new CustomerService();

	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = CommonUtils.toBean(request.getParameterMap(),
				Customer.class);
		customer.setCid(CommonUtils.uuid());
		service.addCustomer(customer);
		request.setAttribute("msg", "用户添加成功");
		return "f:/msg.jsp";
	}

	public String find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		Customer customer = service.find(cid);
		request.setAttribute("customer", customer);
		return "f:/edit.jsp";
	}

	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = CommonUtils.toBean(request.getParameterMap(),
				Customer.class);
		System.out.println(customer);
		customer = encoding(customer);
		int pc = getPc(request);// 页码
		int ps = 10;// 页面大小
		PageBean<Customer> pb = service.query(customer, pc, ps);
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);
		return "f:/list.jsp";
	}

	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = CommonUtils.toBean(request.getParameterMap(),
				Customer.class);
		service.editCustomer(customer);
		request.setAttribute("msg", "用户信息更新成功");
		return "f:/msg.jsp";
	}

	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		service.delete(cid);
		request.setAttribute("msg", "用户删除成功");
		return "f:/msg.jsp";
	}

	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pc = getPc(request);// 页码
		int ps = 10;// 页面大小
		PageBean<Customer> pb = service.findAll(pc, ps);
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);
		return "f:/list.jsp";
	}

	private int getPc(HttpServletRequest request) {
		String pc = request.getParameter("pc");
		// 第一次请求时
		if (pc == null || pc.trim().isEmpty()) {
			return 1;
		}
		// 后面请求时
		return Integer.parseInt(pc);
	}

	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String queryString = request.getQueryString();
		if (queryString.contains("&pc=")) {
			// &pc=一定出现在URL参数的最后
			int index = queryString.lastIndexOf("&pc=");
			queryString = queryString.substring(0, index);
		}
		return contextPath + servletPath + "?" + queryString;
	}

	private Customer encoding(Customer customer)
			throws UnsupportedEncodingException {
		String cname = customer.getCname();
		String gender = customer.getGender();
		String cellphone = customer.getCellphone();
		String email = customer.getEmail();
		if (cname != null && !cname.trim().isEmpty()) {
			cname = new String(cname.getBytes("UTF-8"), "UTF-8");
			customer.setCname(cname);
		}

		if (gender != null && !gender.trim().isEmpty()) {
			gender = new String(gender.getBytes("UTF-8"), "UTF-8");
			customer.setGender(gender);
		}
		if (cellphone != null && !cellphone.trim().isEmpty()) {
			cellphone = new String(cellphone.getBytes("UTF-8"), "UTF-8");
			customer.setCellphone(cellphone);
		}
		if (email != null && !email.trim().isEmpty()) {
			email = new String(email.getBytes("UTF-8"), "UTF-8");
			customer.setEmail(email);
		}
		return customer;
	}
}
