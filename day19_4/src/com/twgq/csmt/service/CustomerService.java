package com.twgq.csmt.service;

import com.tcwgq.csmt.dao.impl.CustomerDaoJdbcImpl;
import com.tcwgq.csmt.domain.Customer;
import com.tcwgq.csmt.domain.PageBean;

public class CustomerService {
	private CustomerDaoJdbcImpl dao = new CustomerDaoJdbcImpl();

	public void addCustomer(Customer customer) {
		dao.save(customer);
	}

	public Customer find(String cid) {
		return dao.find(cid);
	}

	public PageBean<Customer> findAll(int pc, int ps) {
		return dao.findAll(pc, ps);
	}

	public void editCustomer(Customer customer) {
		dao.update(customer);
	}

	public void delete(String cid) {
		dao.delete(cid);
	}

	public PageBean<Customer> query(Customer customer, int pc, int ps) {
		PageBean<Customer> pb = dao.query(customer, pc, ps);
		return pb;
	}
}
