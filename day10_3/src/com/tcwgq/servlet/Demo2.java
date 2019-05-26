package com.tcwgq.servlet;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 获取类路径下的资源
 * 
 * @author lenovo
 * 
 */
public class Demo2 {
	@Test
	public void fun() throws IOException {
		/**
		 * ClassLoader获取资源时，不以"/"开头
		 */
		ClassLoader cl = Demo2.class.getClassLoader();
		InputStream is = cl.getResourceAsStream("a.txt");
		System.out.println(IOUtils.toString(is));
	}

	@Test
	public void fun1() throws IOException {
		/**
		 * Class获取资源时，以"/"开头相对于classes目录
		 */
		Class c = Demo2.class;
		InputStream is = c.getResourceAsStream("/a.txt");
		System.out.println(IOUtils.toString(is));
	}

	@Test
	public void fun2() throws IOException {
		/**
		 * Class获取资源时，不以"/"开头相对于当前.class文件所在目录
		 */
		Class c = Demo2.class;
		InputStream is = c.getResourceAsStream("hello.txt");
		System.out.println(IOUtils.toString(is));
	}
}
