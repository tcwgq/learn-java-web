package com.tcwgq.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Demo {
	// 获取Class文件的三种方式
	@Test
	public void fun() throws ClassNotFoundException {
		Class<?> c1 = Class.forName("com.tcwgq.reflect.Person");
		Class<?> c2 = Person.class;
		Class<?> c3 = new Person().getClass();
	}

	// 通过反射获取类的实例，实际上是操作无参数的构造方法
	@Test
	public void fun1() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Class<?> c = Class.forName("com.tcwgq.reflect.Person");
		Person p = (Person) c.newInstance();
		p.setName("aaa");
		System.out.println(p.getName());
	}

	// 获取有参数的构造方法
	@Test
	public void fun2() throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Class<?> c = Class.forName("com.tcwgq.reflect.Person");
		Constructor<?> constructor = c.getConstructor(String.class, int.class);
		Person p = (Person) constructor.newInstance("林青霞", 27);
		System.out.println(p);
	}
}
