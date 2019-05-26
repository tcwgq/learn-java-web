package com.tcwgq.csmt.dao.impl;

import org.junit.Test;

import cn.itcast.utils.CommonUtils;

import com.tcwgq.csmt.domain.Customer;

public class BatchInsert {
	private CustomerDaoJdbcImpl dao = new CustomerDaoJdbcImpl();

	@Test
	public void batchInsert() {
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
}
