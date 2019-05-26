package com.twgq.csmt.service;

import java.util.List;

import com.tcwgq.csmt.dao.impl.CustomerDaoJdbcImpl;
import com.tcwgq.csmt.domain.Customer;

public class CustomerService {
	private CustomerDaoJdbcImpl dao = new CustomerDaoJdbcImpl();

	public void addCustomer(Customer customer) {
		dao.save(customer);
	}

	public Customer find(String cid) {
		return dao.find(cid);
	}

	public List<Customer> findAll() {
		return dao.findAll();
	}

	public void editCustomer(Customer customer) {
		dao.update(customer);
	}

	public void delete(String cid) {
		dao.delete(cid);
	}

	public List<Customer> query(Customer customer) {
		List<Customer> customers = dao.query(customer);
		return customers;
	}
}
