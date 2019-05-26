package com.tcwgq.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

/**
 * 通过反射获取子类传递的泛型信息
 * 
 * @author lenovo
 * 
 */
public class Demo1 {
	@Test
	public void fun1() {
		new B();
	}
}

class A<T> {

	public A() {
		// 在这里获取子类传递的泛型信息
		Class<?> clazz = this.getClass();
		Type type = clazz.getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		Class<?> c = (Class<?>) types[0];
		System.out.println(c.getName());
	}

}

class B extends A<String> {

}

class C extends A<Integer> {

}