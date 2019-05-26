package com.tcwgq.csmt.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.tcwgq.csmt.domain.Customer;
import com.tcwgq.csmt.domain.PageBean;

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

	public PageBean<Customer> findAll(int pc, int ps) {
		// 注意，limit子句要放在最后
		String sql1 = "select * from t_customer order by cname limit ?, ?";
		int size = pc - 1 < 0 ? 0 : pc - 1;
		Object[] params = { ps * size, ps };
		String sql2 = "select count(*) from t_customer";
		PageBean<Customer> pb = new PageBean<Customer>();
		pb.setPs(ps);
		try {
			List<Customer> list = qr.query(sql1, new BeanListHandler<Customer>(
					Customer.class), params);
			pb.setBeanList(list);
			Number result = qr.query(sql2, new ScalarHandler<Long>());
			int tr = result.intValue();
			// 处理页码显示的问题
			if (tr == 0) {
				pb.setPc(0);
			} else {
				pb.setPc(pc);
			}
			pb.setTr(tr);
			return pb;
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

	public PageBean<Customer> query(Customer customer, int pc, int ps) {
		System.out.println(customer);
		PageBean<Customer> pb = new PageBean<Customer>();
		pb.setPs(ps);
		StringBuilder sb = new StringBuilder(
				"select count(*) from t_customer where 1=1");
		List<Object> list = new ArrayList<Object>();

		StringBuilder sb1 = new StringBuilder(
				"select * from t_customer where 1=1");
		List<Object> list1 = new ArrayList<Object>();
		String cname = customer.getCname();
		if (cname != null && !cname.trim().isEmpty()) {
			sb.append(" and cname like ?");
			list.add("%" + cname + "%");
			sb1.append(" and cname like ?");
			list1.add("%" + cname + "%");
		}
		String gender = customer.getGender();
		if (gender != null && !gender.trim().isEmpty()) {
			sb.append(" and gender=?");
			list.add(gender);
			sb1.append(" and gender=?");
			list1.add(gender);
		}
		String cellphone = customer.getCellphone();
		if (cellphone != null && !cellphone.trim().isEmpty()) {
			sb.append(" and cellphone like ?");
			list.add("%" + cellphone + "%");
			sb1.append(" and cellphone like ?");
			list1.add("%" + cellphone + "%");
		}
		String email = customer.getEmail();
		if (email != null && !email.trim().isEmpty()) {
			sb.append(" and email like ?");
			list.add("%" + email + "%");
			sb1.append(" and email like ?");
			list1.add("%" + email + "%");
		}
		sb1.append(" limit ?, ?");
		// 处理没有记录的情况，即tp=0的情况
		int size = pc - 1 < 0 ? 0 : pc - 1;
		list1.add(size * ps);
		list1.add(ps);
		String sql = sb.toString();
		Object[] params = list.toArray();
		String sql1 = sb1.toString();
		Object[] params1 = list1.toArray();
		System.out.println(sql1);
		System.out.println(Arrays.toString(params));
		try {
			Number result = qr.query(sql, new ScalarHandler<Long>(), params);
			int tr = result.intValue();
			pb.setTr(tr);
			if (tr == 0) {
				pb.setPc(0);
			} else {
				pb.setPc(pc);
			}
			List<Customer> customers = qr.query(sql1,
					new BeanListHandler<Customer>(Customer.class), params1);
			pb.setBeanList(customers);
			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
