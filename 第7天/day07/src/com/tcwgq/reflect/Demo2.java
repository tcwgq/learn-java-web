package com.tcwgq.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 使用泛型操作普通方法
 * 
 * @author lenovo
 * 
 */
public class Demo2 {
	// 获取Person中的私有成员方法
	@Test
	public void fun() throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Class<?> c = Class.forName("com.tcwgq.reflect.Person");
		Object obj = c.newInstance();
		Method method = c.getDeclaredMethod("method");
		method.setAccessible(true);
		method.invoke(obj);
	}

	// 获取Person中的带参成员方法
	@Test
	public void fun1() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException {
		Class<?> c = Class.forName("com.tcwgq.reflect.Person");
		Object obj = c.newInstance();
		// 操作静态方法时，不需要得到obj实例
		Method method = c.getDeclaredMethod("setName", String.class);
		method.invoke(obj, "HellowWorld");
		System.out.println(obj);
	}

	// 通过反射操作静态方法
	@Test
	public void fun2() throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Class<?> c = Class.forName("com.tcwgq.reflect.Person");
		// Object obj = c.newInstance();
		// 操作静态方法时，不需要得到类的实例
		Method method = c.getDeclaredMethod("function");
		// 静态方法，不需要创建类的实例，直接传个null即可
		method.invoke(null);
	}
}
