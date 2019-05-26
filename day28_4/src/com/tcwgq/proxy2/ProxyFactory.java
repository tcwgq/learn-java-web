package com.tcwgq.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	private Waiter targetObject;// 目标对象
	private BeforeAdvice before;// 前置增强
	private AfterAdvice after;// 后置增强

	public void setTargetObject(Waiter targetObject) {
		this.targetObject = targetObject;
	}

	public void setBefore(BeforeAdvice before) {
		this.before = before;
	}

	public void setAfter(AfterAdvice after) {
		this.after = after;
	}

	public Object createProxyObjcet() {
		ClassLoader loader = this.getClass().getClassLoader();
		Class<?>[] interfaces = targetObject.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if (before != null) {
					before.before();
				}
				// 考虑调用目标对象的哪个方法？
				// 不能把方法写死，所有使用了反射方法调用
				Object reusult = method.invoke(targetObject, args);
				if (after != null) {
					after.after();
				}
				return reusult;
			}

		};
		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, h);
		return proxyObject;
	}
}
