package com.tcwgq.enumdemo;

public class EnumTest {
	private int color;

	public void test() {
		// this.color = 1;
		// this.color = Color1.RED;
		this.color = 1000;// 赋值出现错误
	}
}

class Color1 {
	public static final int RED = 1;
	public static final int YELLOW = 2;
	public static final int GREEN = 3;
}