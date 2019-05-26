package com.tcwgq.enumdemo;

public class EnumTest1 {
	private Color2 color;

	public void test() {
		// this.color = Color2.GREEN;//这种赋值方式没错
		// this.color = new Color2();// 不能保证赋的值是从Color2中取的
		this.color = Color2.GREEN;
	}
}

class Color2 {
	private Color2() {
		// 构造方法私有化，保证不能new
	}

	public static final Color2 RED = new Color2();
	public static final Color2 YELLOW = new Color2();
	public static final Color2 GREEN = new Color2();
}