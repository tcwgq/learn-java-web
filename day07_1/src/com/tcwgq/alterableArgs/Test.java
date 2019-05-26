package com.tcwgq.alterableArgs;

/**
 * 可变参数 以下场景可以使用可变参数 需要注意的地方： 方法的参数列表中只能出现一个可变参数 可变参数必须放在方法的参数列表的最后
 * 
 * @author lenovo
 * 
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(sum(1, 2));
		System.out.println(sum(1, 2, 3));
	}

	public static int sum(int a, int b) {
		return a + b;
	}

	public static int sum(int a, int b, int c) {
		return a + b + c;
	}

	// 使用可变参数
	public static int sum(int... args) {
		// 可变参数必须放在参数列表的最后
		// 此处args就是一个数组
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			sum += args[i];
		}
		return sum;
	}
}
