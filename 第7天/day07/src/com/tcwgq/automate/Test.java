package com.tcwgq.automate;

public class Test {
	public static void main(String[] args) {
		Integer i = 10;// 自动装箱
		int b = i + 10;// 自动拆箱
		System.out.println(b);
	}

	// 在1.4中实现拆装箱，注意，此处不是自动了
	public static void test() {
		Integer a = new Integer(10);// 装箱
		int b = a.intValue();// 拆箱
		System.out.println(b);
	}
}
