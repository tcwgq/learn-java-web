package com.tcwgq.bookstore.order.junit.test;

import java.util.List;

import org.junit.Test;

import com.tcwgq.bookstore.order.dao.OrderDao;
import com.tcwgq.bookstore.order.domain.Order;

public class OrderDaoTest {
	private OrderDao dao = new OrderDao();

	@Test
	public void testAdd() {

	}

	@Test
	public void testAddItem() {

	}

	@Test
	public void testFindAll() {
		List<Order> orders = dao.findAll("B10157FD257E41A1B9A993BF286DF10E");
		System.out.println(orders);
	}

	@Test
	public void testHmac() {

	}

}
