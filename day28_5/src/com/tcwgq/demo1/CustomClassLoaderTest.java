package com.tcwgq.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		ClassLoader loader = new FileSystemClassLoader("F:\\classpath");
		Class clazz = loader.loadClass("cn.itcast.utils.CommonUtils");
		Method method = clazz.getMethod("md5", String.class);
		String result = (String) method.invoke(null, "qdmmy6");
		System.out.println(result);
	}
}
