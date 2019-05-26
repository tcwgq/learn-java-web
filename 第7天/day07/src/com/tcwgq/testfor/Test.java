package com.tcwgq.testfor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 增强for： 实现Iterable接口的集合可以使用增强for遍历。
 * List,Set集合都实现了Iterable接口，因此可以使用增强for遍历，Map集合没有实现该接口，不能使用增强for遍历。
 * 增强for出现的目的：为了替代迭代器。增强for的底层就是迭代器。
 * 
 * @author lenovo
 * 
 */
public class Test {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("world");
		list.add("java");
		// 使用增强for遍历
		for (String s : list) {
			System.out.println(s);
		}
		// 使用迭代器遍历
		Iterator<String> it = list.iterator();
	}
}
