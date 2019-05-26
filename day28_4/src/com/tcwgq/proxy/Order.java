package com.tcwgq.proxy;

public class Order {
	private int id;
	private double total;

	public Order() {
	}

	public Order(int id, double total) {
		this.id = id;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", total=" + total + "]";
	}

}
