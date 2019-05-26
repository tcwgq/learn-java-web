package com.tcwgq.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟ThreadLocal类
 * 
 * @author lenovo
 * 
 * @param <T>
 */
public class MyThreadLocal<T> {
	Map<Thread, T> map = new HashMap<Thread, T>();

	public void set(T data) {
		this.map.put(Thread.currentThread(), data);
	}

	public T get() {
		return this.map.get(Thread.currentThread());
	}

	public void remove() {
		this.map.remove(Thread.currentThread());
	}
}
