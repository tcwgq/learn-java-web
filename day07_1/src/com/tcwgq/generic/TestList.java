package com.tcwgq.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		for (String s : list) {
			System.out.println(s);
		}
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
