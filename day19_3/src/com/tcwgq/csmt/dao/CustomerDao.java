package com.tcwgq.csmt.dao;

import com.tcwgq.csmt.domain.Customer;

public interface CustomerDao {
	public void save(Customer customer);

	public Customer getCustomer();
}
