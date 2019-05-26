package com.tcwgq.threadlocal;

/**
 * ThreadLocal类的使用
 * 
 * @author lenovo
 * 
 */
public class ThreadLocalTest {
	public static void main(String[] args) {
		final ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set("hello");
		System.out.println(tl.get());
		// 两个线程不同
		new Thread() {
			public void run() {
				System.out.println(tl.get());
			};
		}.start();
	}

}
