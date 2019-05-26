package com.tcwgq.bookstore.order.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.bookstore.book.domain.Book;
import com.tcwgq.bookstore.order.domain.Order;
import com.tcwgq.bookstore.order.domain.OrderItem;

public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();

	public void add(Order order) {
		String sql = "insert into orders values(?, ?, ?, ?, ?, ?)";
		Object[] params = { order.getOid(),
				new Timestamp(order.getOrdertime().getTime()),
				order.getTotal(), order.getState(), order.getUser().getUid(),
				order.getAddress() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addItem(List<OrderItem> orderItems) {
		String sql = "insert into orderitem values(?, ?, ?, ?, ?)";
		Object[][] params = new Object[orderItems.size()][];
		for (int i = 0; i < orderItems.size(); i++) {
			OrderItem item = orderItems.get(i);
			params[i] = new Object[] { item.getIid(), item.getCount(),
					item.getSubtotal(), item.getOrder().getOid(),
					item.getBook().getBid() };
		}
		try {
			qr.batch(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Order> findAll(String uid) {
		String sql = "select * from orders where uid = ? order by ordertime desc";
		try {
			List<Order> orders = qr.query(sql, new BeanListHandler<Order>(
					Order.class), uid);
			for (Order order : orders) {
				List<OrderItem> OrderItemList = getOrderItem(order);
				order.setOrderItems(OrderItemList);
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<OrderItem> getOrderItem(Order order) {
		String sql = "select * from orderitem, book where orderitem.bid = book.bid and orderitem.oid = ?";
		try {
			List<Map<String, Object>> mapList = qr.query(sql,
					new MapListHandler(), order.getOid());
			List<OrderItem> orderItemList = toOrderItemList(mapList);
			return orderItemList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> items = new ArrayList<OrderItem>();
		for (Map<String, Object> map : mapList) {
			OrderItem item = toOrderItem(map);
			items.add(item);
		}
		return items;
	}

	private OrderItem toOrderItem(Map<String, Object> map) {
		OrderItem item = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		item.setBook(book);
		return item;
	}

	public Order getOrder(String oid) {
		String sql = "select * from orders where oid = ?";
		try {
			Order order = qr.query(sql, new BeanHandler<Order>(Order.class),
					oid);
			List<OrderItem> OrderItemList = getOrderItem(order);
			order.setOrderItems(OrderItemList);
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getStateByOid(String oid) {
		String sql = "select * from orders where oid = ?";
		try {
			Order order = qr.query(sql, new BeanHandler<Order>(Order.class),
					oid);
			return order.getState();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void updateState(String oid, int state) {
		String sql = "update orders set state = ? where oid = ?";
		try {
			qr.update(sql, state, oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAddress(String oid, String address) {
		String sql = "update orders set address = ? where oid = ?";
		try {
			qr.update(sql, address, oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
