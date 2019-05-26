package com.tcwgq.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitDemo {
	@Test
	public void fun() {
		System.out.println("HelloWorld");
	}

	@Test
	public void fun1() {
		System.out.println("ignore");
	}

	@Before
	public void fun2() {
		System.out.println("before");
	}

	@After
	public void fun3() {
		System.out.println("After");
	}
}
