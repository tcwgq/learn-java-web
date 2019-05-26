package com.tcwgq.bookstore.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> items = new LinkedHashMap<String, CartItem>();

	public void add(CartItem item) {
		// 需要考虑合并项的问题
		String key = item.getBook().getBid();
		if (this.items.containsKey(key)) {
			int count = this.items.get(key).getCount() + item.getCount();
			this.items.get(key).setCount(count);
		} else {
			this.items.put(key, item);
		}
	}

	public void remove(String bid) {
		this.items.remove(bid);
	}

	public void clear() {
		this.items.clear();
	}

	public Collection<CartItem> getCartItems() {
		return this.items.values();
	}

	public double getTotal() {
		BigDecimal total = new BigDecimal("0");
		for (CartItem item : items.values()) {
			// 此处需要考虑二进制运算误差的问题，详情请看test
			total = total.add(new BigDecimal(item.getSubtotal() + ""));
		}
		return total.doubleValue();
	}
}
