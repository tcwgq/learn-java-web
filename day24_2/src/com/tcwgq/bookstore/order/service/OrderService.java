package com.tcwgq.bookstore.order.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.jdbc.JdbcUtils;

import com.tcwgq.bookstore.order.dao.OrderDao;
import com.tcwgq.bookstore.order.domain.Order;
import com.tcwgq.bookstore.order.exception.OrderException;

public class OrderService {
	private OrderDao dao = new OrderDao();

	public void add(Order order) throws SQLException {
		try {
			JdbcUtils.beginTransaction();
			dao.add(order);
			dao.addItem(order.getOrderItems());
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			JdbcUtils.rollbackTransaction();
		}
	}

	public List<Order> showOrders(String uid) {
		return dao.findAll(uid);
	}

	public Order getOrder(String oid) {

		return dao.getOrder(oid);
	}

	public void comfirm(String oid) throws OrderException {
		int state = dao.getStateByOid(oid);
		if (state != 3) {
			throw new OrderException("订单确认收货失败！");
		}
		dao.updateState(oid, 4);
	}

	public void back(String oid) {
		int state = dao.getStateByOid(oid);
		if (state == 1) {
			dao.updateState(oid, 2);
		}
	}

	public void updateOrderAddress(String oid, String address) {
		dao.updateAddress(oid, address);
	}
}
