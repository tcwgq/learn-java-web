package com.tcwgq.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * @author lenovo
 *
 */
public class ManWaiterInvocationHandler implements InvocationHandler {
	private Waiter waiter;

	public ManWaiterInvocationHandler(Waiter waiter) {
		this.waiter = waiter;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("您好");
		waiter.serve();
		System.out.println("再见");
		return null;
	}

}
