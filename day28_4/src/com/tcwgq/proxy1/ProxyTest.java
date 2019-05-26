package com.tcwgq.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void fun() {
		ClassLoader loader = this.getClass().getClassLoader();
		Class<?>[] interfaces = { Waiter.class };
		Waiter waiter = new ManWaiter();
		InvocationHandler h = new ManWaiterInvocationHandler(waiter);
		Waiter waiterProxy = (Waiter) Proxy.newProxyInstance(loader,
				interfaces, h);
		waiterProxy.serve();

	}
}
