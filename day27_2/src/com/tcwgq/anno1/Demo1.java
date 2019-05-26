//@anno
package com.tcwgq.anno1;

@anno
public class Demo1 {
	@anno
	private String name;
	private int age;

	@anno
	public Demo1() {
	}

	@anno
	public Demo1(@anno String name, int age) {
		this.name = name;
		this.age = age;
	}

	@anno
	public String getName() {
		return name;
	}

	public void setName(@anno String name) {
		// @Anno//不能放在这里
		this.name = name;
	}

	public int getAge() {
		@anno
		String address = null;
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

@interface anno {

}
