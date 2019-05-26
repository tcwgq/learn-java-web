package com.tcwgq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void fun1() {
		// 关于类加载的问题，请查阅资料
		// 借用本类的类加载器加载接口文件
		ClassLoader loader = this.getClass().getClassLoader();
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println(proxy.getClass().getName());
				System.out.println(method.getName());
				for (Object obj : args) {
					System.out.println(obj);
				}
				System.out.println("你好，动态代理！");
				return new User(2, "lisi");
			}
		};
		Object obj = Proxy.newProxyInstance(loader, new Class[] {
				UserDao.class, OrderDao.class }, handler);
		UserDao userDao = (UserDao) obj;
		System.out.println(userDao.getClass().getName());
		// OrderDao orderDao = (OrderDao) obj;
		// User user = new User(1, "zhangSan");
		// 代理类对象的所有方法调用都是执行InvocationHandler的invoke方法
		// userDao.add(user);
		// userDao.findAll();
		// orderDao.delete(10);
		// orderDao.update(1);
		User u = userDao.findById(10);
		System.out.println(u);
	}
}
