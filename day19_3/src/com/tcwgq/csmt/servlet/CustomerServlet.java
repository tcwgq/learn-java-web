package com.tcwgq.csmt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.csmt.domain.Customer;
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
		List<Customer> customers = service.query(customer);
		request.setAttribute("customers", customers);
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
		List<Customer> list = service.findAll();
		request.setAttribute("customers", list);
		return "f:/list.jsp";
	}

}
