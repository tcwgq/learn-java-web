package com.tcwgq.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 反射注解
 * 
 * @author lenovo
 * 
 */
public class Demo1 {
	@Test
	public void fun1() {
		Class<Demo> c = Demo.class;
		Anno anno = c.getAnnotation(Anno.class);
		System.out.println(anno.name() + "--" + anno.age());
	}

	@Test
	public void fun2() throws SecurityException, NoSuchMethodException {
		Class<Demo> c = Demo.class;
		Method method = c.getMethod("fun1");
		Anno anno = method.getAnnotation(Anno.class);
		System.out.println(anno.name() + "--" + anno.age());
	}
}

@Anno(name = "zhangSan", age = 23)
class Demo {
	@Anno(name = "liSi", age = 34)
	public void fun1() {

	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface Anno {
	String name();

	int age();
}