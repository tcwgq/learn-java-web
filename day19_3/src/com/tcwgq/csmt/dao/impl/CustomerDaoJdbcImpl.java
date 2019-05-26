package com.tcwgq.csmt.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.tcwgq.csmt.domain.Customer;

public class CustomerDaoJdbcImpl {
	private QueryRunner qr = new TxQueryRunner();

	public void save(Customer customer) {
		String sql = "insert into t_customer values (?, ?, ?, ?, ?, ?, ?)";
		Object[] params = { customer.getCid(), customer.getCname(),
				customer.getGender(), customer.getBirthday(),
				customer.getCellphone(), customer.getEmail(),
				customer.getDescription() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Customer find(String cid) {
		String sql = "select * from t_customer where cid = ?";
		Object[] params = { cid };
		try {
			Customer customer = qr.query(sql, new BeanHandler<Customer>(
					Customer.class), params);
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Customer> findAll() {
		String sql = "select * from t_customer";
		try {
			List<Customer> list = qr.query(sql, new BeanListHandler<Customer>(
					Customer.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Customer customer) {
		String sql = "update t_customer set cname=?, gender=?, birthday=?, cellphone=?, email=?, description=? where cid=?";
		Object[] params = { customer.getCname(), customer.getGender(),
				customer.getBirthday(), customer.getCellphone(),
				customer.getEmail(), customer.getDescription(),
				customer.getCid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String cid) {
		String sql = "delete from t_customer where cid = ?";
		Object[] params = { cid };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Customer> query(Customer customer) {
		StringBuilder sb = new StringBuilder(
				"select * from t_customer where 1=1");
		List<Object> list = new ArrayList<Object>();
		String cname = customer.getCname();
		if (cname != null && !cname.trim().isEmpty()) {
			sb.append(" and cname like ?");
			list.add("%" + cname + "%");
		}
		String gender = customer.getGender();
		if (gender != null && !gender.trim().isEmpty()) {
			sb.append(" and gender=?");
			list.add(gender);
		}
		String cellphone = customer.getCellphone();
		if (cellphone != null && !cellphone.trim().isEmpty()) {
			sb.append(" and cellphone like ?");
			list.add("%" + cellphone + "%");
		}
		String email = customer.getEmail();
		if (email != null && !email.trim().isEmpty()) {
			sb.append(" and email like ?");
			list.add("%" + email + "%");
		}
		String sql = sb.toString();
		Object[] params = list.toArray();
		try {
			List<Customer> customers = qr.query(sql,
					new BeanListHandler<Customer>(Customer.class), params);
			return customers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
