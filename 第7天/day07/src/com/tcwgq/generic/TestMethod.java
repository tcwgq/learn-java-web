package com.tcwgq.generic;

/**
 * 泛型方法： 泛型必须写在函数返回值的前面，用<>包起来。
 * 
 * @author lenovo
 * 
 */
public class TestMethod {
	public static void main(String[] args) {
		TestMethod.diplay("aaa");
		TestMethod.diplay(111);
		TestMethod.diplay(String.class);
	}

	public static <T> void diplay(T t) {
		System.out.println(t.getClass());
	}
}
