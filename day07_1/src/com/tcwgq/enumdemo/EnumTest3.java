package com.tcwgq.enumdemo;

public class EnumTest3 {

}

enum Color4 {
	RED("red") {

		@Override
		public void print() {
			// TODO Auto-generated method stub

		}

	},
	YELLOW("yellow") {

		@Override
		public void print() {
			// TODO Auto-generated method stub

		}

	},
	GREEN("green") {

		@Override
		public void print() {
			// TODO Auto-generated method stub

		}

	};
	// 枚举中带有构造方法
	private Color4(String s) {

	}

	// 枚举中带有抽象方法，要求每个实例都必须重写抽象方法
	public abstract void print();

}