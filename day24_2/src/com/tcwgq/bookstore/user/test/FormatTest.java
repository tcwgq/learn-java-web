package com.tcwgq.bookstore.user.test;

import java.text.MessageFormat;

import org.junit.Test;

public class FormatTest {
	@Test
	public void testSimpleDateFormat() {

	}

	@Test
	public void testNumberFormat() {

	}

	@Test
	public void testMessageFormat() {
		String message = MessageFormat.format("{0}或{1}错误", "用户名", "密码");
		System.out.println(message);
	}
}
