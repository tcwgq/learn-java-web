package com.tcwgq.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		// 第一种遍历方式
		Set<String> key = map.keySet();
		for (String k : key) {
			String value = map.get(k);
			System.out.println(value);
		}
		// 第二种遍历方式
		Set<Map.Entry<String, String>> set = map.entrySet();
		for (Map.Entry<String, String> entry : set) {
			String k = entry.getKey();
			String v = entry.getValue();
			System.out.println(k + "--" + v);
		}
	}
}
