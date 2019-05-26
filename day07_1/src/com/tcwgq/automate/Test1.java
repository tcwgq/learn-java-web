package com.tcwgq.automate;

public class Test1 {
	public static void main(String[] args) {
		dosomething(10);
	}

	// 在jdk1.4中肯定调用这个方法，jdk向下兼容，所以在jdk1.5中，还是调用这个方法
	public static void dosomething(double d) {
		System.out.println("double......");
	}

	public static void dosomething(Integer i) {
		System.out.println("integer......");
	}
}
