package com.tcwgq.demo;

import org.junit.Test;

public class ClassLoaderTest {
	@Test
	public void fun() throws ClassNotFoundException {
		Class.forName("abc");
	}
}
