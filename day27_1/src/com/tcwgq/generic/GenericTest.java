package com.tcwgq.generic;

public class GenericTest {
	public static void main(String[] args) {
		B b = new B();
		b.setT(10);
		System.out.println(b.getT());
		C<String> c = new C<String>();
		c.setT("hello");
		System.out.println(c.getT());
		D<Integer> d = new D<Integer>();
		d.setT(100);
		System.out.println(d.getT());
	}
}

class Student {
	public <T> T getT(T t) {
		return t;
	}
}

class A<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}

class B extends A<Integer> {

}

class C<T> extends A<String> {

}

class D<T> extends A<T> {

}
