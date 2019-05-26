package com.tcwgq.csmt.dao.impl;

import java.util.List;

import org.junit.Test;

import cn.itcast.utils.CommonUtils;

import com.tcwgq.csmt.domain.Customer;
import com.tcwgq.csmt.domain.PageBean;

public class CustomerDaoJdbcImplTest {
	private CustomerDaoJdbcImpl dao = new CustomerDaoJdbcImpl();

	@Test
	public void testSave() {
		for (int i = 1; i <= 300; i++) {
			Customer c = new Customer();
			c.setCid(CommonUtils.uuid());
			c.setCname("name_" + i);
			c.setBirthday("1992-04-06");
			c.setCellphone("155" + i);
			c.setGender(i % 2 == 0 ? "男" : "女");
			c.setEmail("name_" + i + "@163.com");
			c.setDescription("我是客户" + i);
			dao.save(c);
		}
	}

	@Test
	public void testFind() {
	}

	@Test
	public void testFindAll() {
		PageBean<Customer> pb = dao.findAll(1, 10);
		System.out.println(pb.getPc());
		System.out.println(pb.getPs());
		System.out.println(pb.getTp());
		System.out.println(pb.getTr());
		List<Customer> list = pb.getBeanList();
		for (Customer c : list) {
			System.out.println(c);
		}
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testQuery() {
	}

}
