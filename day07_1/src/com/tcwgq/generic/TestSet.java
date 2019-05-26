package com.tcwgq.generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * set集合特点：无序，元素不可重复。
 * @author lenovo
 *
 */
public class TestSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		for (String s : set) {
			System.out.println(s);
		}
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
