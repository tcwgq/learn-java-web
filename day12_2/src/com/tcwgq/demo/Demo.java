package com.tcwgq.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.tcwgq.domain.User;
import com.tcwgq.utils.CommonUtils;

public class Demo {
	@Test
	public void fun1() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, InvocationTargetException,
			NoSuchMethodException {
		String className = "com.tcwgq.domain.Person";
		Object obj = Class.forName(className).newInstance();
		BeanUtils.setProperty(obj, "id", "23");
		BeanUtils.setProperty(obj, "name", "zhangSan");
		BeanUtils.setProperty(obj, "flag", "true");
		// 没有的属性，赋不上值，不会抛出异常，视频上没抛出异常，在此抛出异常，版本改进了
		// BeanUtils.setProperty(obj, "xxx", "XXX");
		String name = BeanUtils.getProperty(obj, "name");
		System.out.println(name);
		System.out.println(obj);
	}

	@Test
	public void fun2() throws IllegalAccessException, InvocationTargetException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "zhangSan");
		map.put("password", "123");
		User user = new User();
		// populate装入，填入的意思
		BeanUtils.populate(user, map);
		System.out.println(user);
	}

	@Test
	public void fun3() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "zhangSan");
		map.put("password", "123");
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user);
	}
}
