package com.tcwgq.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.tcwgq.domain.User;

public class JsonTest {
	@Test
	public void fun() {
		JSONObject map = new JSONObject();
		map.put("name", "zhangSan");
		map.put("age", 23);
		map.put("sex", 23);
		String s = map.toString();
		System.out.println(s);
	}

	@Test
	public void fun1() {
		User user = new User(1, "liSi", "1234");
		JSONObject map = JSONObject.fromObject(user);
		String s = map.toString();
		System.out.println(s);
	}

	@Test
	public void fun2() {
		User user1 = new User(1, "zhangSan", "123");
		User user2 = new User(2, "liSi", "1234");
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		JSONArray list = new JSONArray();
		list.add(user1);
		list.add(user2);
		String s = list.toString();
		System.out.println(s);
		System.out.println(JSONArray.fromObject(users));
	}
}
