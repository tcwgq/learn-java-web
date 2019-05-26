package com.tcwgq.staticimport;

import static java.lang.Math.abs;

/**
 * 静态导入，不常用，了解。
 * 应用场景：设计计算器程序时，所用的函数都是Math类的，这时使用静态导入可以直接调用函数，不用加Math.
 * 
 * @author lenovo
 * 
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(abs(-10));// 直接调用，不用带类名
	}
}
