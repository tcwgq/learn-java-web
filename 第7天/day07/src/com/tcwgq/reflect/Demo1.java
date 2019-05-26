package com.tcwgq.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class Demo1 {
	// 使用反射操作属性
	@Test
	public void fun() throws ClassNotFoundException, SecurityException,
			NoSuchFieldException, InstantiationException,
			IllegalAccessException {
		Class<?> c = Class.forName("com.tcwgq.reflect.Person");
		Object obj = c.newInstance();
		Field name = c.getDeclaredField("name");// 获取类中所有字段，getField()获取类中公共字段
		name.setAccessible(true);
		name.set(obj, "tcwgq");// 相当于p.name = "tcwgq"
		System.out.println(name.get(obj));
	}
}
