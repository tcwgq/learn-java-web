package com.tcwgq.proxy2;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void fun() {
		ProxyFactory factory = new ProxyFactory();
		factory.setTargetObject(new ManWaiter());
		factory.setBefore(new BeforeAdvice() {
			@Override
			public void before() {
				System.out.println("你好！");
			}
		});
		factory.setAfter(new AfterAdvice() {
			@Override
			public void after() {
				System.out.println("再见！");
			}
		});
		Waiter waiter = (Waiter) factory.createProxyObjcet();
		waiter.serve();
	}
}
