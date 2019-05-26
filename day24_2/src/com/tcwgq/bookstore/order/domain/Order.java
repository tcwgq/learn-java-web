package com.tcwgq.bookstore.order.domain;

import java.util.Date;
import java.util.List;

import com.tcwgq.bookstore.user.domain.User;

public class Order {
	private String oid;
	private Date ordertime;
	private double total;
	private int state;// 订单状态1.未付款2.已付款未发货3.已发货未收货4.确认收货
	private User user;
	private String address;
	private List<OrderItem> orderItems;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total="
				+ total + ", state=" + state + ", user=" + user + ", address="
				+ address + "]";
	}

}
