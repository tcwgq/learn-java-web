package com.tcwgq.bookstore.cart.junit.test;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class DoubleTest {

	@Test
	public void testDoble() {
		System.out.println(2.0 - 1.1);
	}

	@Test
	public void testInt() {
		int sum = 1;
		for (int i = 1; i <= 20; i++) {
			sum *= i;
		}
		System.out.println(sum);
	}

	@Test
	public void testBigInteger() {
		BigInteger sum = BigInteger.valueOf(1);
		for (int i = 1; i <= 1000; i++) {
			BigInteger bi = BigInteger.valueOf(i);
			sum = sum.multiply(bi);
		}
		System.out.println(sum);
	}

	@Test
	public void testBigDecimal() {
		BigDecimal a = new BigDecimal("2.0");
		BigDecimal b = new BigDecimal("1.1");
		System.out.println(a.subtract(b).doubleValue());
	}

}
